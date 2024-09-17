package io.quarkiverse.asciidoc.deployment;

import java.io.File;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.pkg.builditem.OutputTargetBuildItem;
import io.quarkus.vertx.http.deployment.spi.GeneratedStaticResourceBuildItem;

class AsciidocProcessor {

    private static final String FEATURE = "asciidoc";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    void generateAsciiDoc(
            BuildProducer<GeneratedStaticResourceBuildItem> generatedStaticResourceProducer,
            OutputTargetBuildItem outputTarget) {

        System.out.println("output target");
        System.out.println(outputTarget.getOutputDirectory());

        try (Asciidoctor asciidoctor = Asciidoctor.Factory.create()) {
            asciidoctor.registerLogHandler(logRecord -> System.out.println(logRecord.getMessage()));

            asciidoctor.convertFile(
                    new File("docs/modules/ROOT/pages/index.adoc"), Options.builder()
                            .backend("html5")
                            .sourceDir(new File("docs/modules/ROOT/pages/"))
                            .toDir(outputTarget.getOutputDirectory().resolve("quarkus-generated-docs").toFile())
                            .mkDirs(true)
                            .toFile(true)
                            .attributes(Attributes.builder()
                                    //.linkCss(true)
                                    //.copyCss(true)
                                    .build())
                            .build());

            /*
             * DirectoryWalker directoryWalker = new AsciiDocDirectoryWalker("docs/modules/ROOT/pages");
             *
             * asciidoctor.convertDirectory(directoryWalker, Options.builder()
             * .backend("html5")
             * .sourceDir(new File("docs/modules/ROOT/pages"))
             * .toDir(outputTarget.getOutputDirectory().resolve("quarkus-generated-docs").toFile())
             * .mkDirs(true)
             * .toFile(true)
             * .attributes(Attributes.builder()
             * //.linkCss(true)
             * //.copyCss(true)
             * .build())
             * .build());
             */

        }
    }
}
