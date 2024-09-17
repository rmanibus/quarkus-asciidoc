package io.quarkiverse.asciidoc.deployment;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;

import java.io.File;
import java.util.List;
import java.util.Map;

@ConfigMapping(prefix = "quarkus.asciidoc")
@ConfigRoot(phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
public interface AsciiDocBuildTimeConfig {

    //@Parameter(property = AsciidoctorMaven.PREFIX + "sourceDirectory", defaultValue = "${basedir}/" + DEFAULT_SOURCE_DIR)
    File sourceDirectory();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "outputDirectory", defaultValue = "${project.build.directory}/generated-docs")
    File outputDirectory();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "outputFile")
    File outputFile();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "preserveDirectories", defaultValue = "false")
    boolean preserveDirectories();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "relativeBaseDir", defaultValue = "false")
    boolean relativeBaseDir();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "projectDirectory", defaultValue = "${basedir}")
    File projectDirectory();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "rootDir", defaultValue = "${basedir}")
    File rootDir();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "baseDir")
    File baseDir();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "skip", defaultValue = "false")
    boolean skip();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "gemPath")
    String gemPath();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "requires")
    List<String> requires();

    //@Parameter
    Map<String, Object> attributes();

    //@Parameter(property = AsciidoctorMaven.PREFIX + Options.ATTRIBUTES)
    String attributesChain();

    //@Parameter(property = AsciidoctorMaven.PREFIX + Options.BACKEND, defaultValue = "html5")
    String backend();

    //@Parameter(property = AsciidoctorMaven.PREFIX + Options.DOCTYPE)
    String doctype();

    //@Parameter(property = AsciidoctorMaven.PREFIX + Options.ERUBY)
    String eruby();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "standalone", defaultValue = "true")
    boolean standalone();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "templateDirs")
    List<File> templateDirs();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "templateEngine")
    String templateEngine();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "templateCache", defaultValue = "true")
    boolean templateCache();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "sourceDocumentName")
    String sourceDocumentName();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "sourceDocumentExtensions")
    //List<String> sourceDocumentExtensions = new ArrayList<>();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "sourcemap", defaultValue = "false")
    boolean sourcemap();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "catalogAssets", defaultValue = "false")
    boolean catalogAssets();

    //@Parameter
    //List<ExtensionConfiguration> extensions = new ArrayList<>();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "embedAssets", defaultValue = "false")
    boolean embedAssets();

    // List of resources to copy to the output directory (e.g., images, css). By default, everything is copied
    //@Parameter
    //List<Resource> resources();

    //@Parameter(property = AsciidoctorMaven.PREFIX + "verbose", defaultValue = "false")
    boolean enableVerbose();

}
