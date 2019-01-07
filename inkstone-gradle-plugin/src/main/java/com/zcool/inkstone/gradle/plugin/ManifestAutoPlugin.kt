package com.zcool.inkstone.gradle.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.api.BaseVariant
import groovy.util.XmlSlurper
import org.gradle.api.DomainObjectSet
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.util.concurrent.atomic.AtomicBoolean

class ManifestAutoPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        println("ManifestAutoPlugin#apply")
        project.plugins.all {
            when (it) {
                is LibraryPlugin -> {
                    println("is LibraryPlugin")
                    project.extensions.getByType(LibraryExtension::class.java).run {
                        genManifest(project, libraryVariants)
                    }
                }
                is AppPlugin -> {
                    println("is AppPlugin")
                    project.extensions.getByType(AppExtension::class.java).run {
                        genManifest(project, applicationVariants)
                    }
                }
            }
        }
    }

    private fun getPackageName(variant: BaseVariant): String {
        val slurper = XmlSlurper(false, false)
        val list = variant.sourceSets.map { it.manifestFile }

        val result = slurper.parse(list[0])
        return result.getProperty("@package").toString()
    }

    private fun genManifest(project: Project, variants: DomainObjectSet<out BaseVariant>) {
        variants.all { variant ->
            val outputDir = project.buildDir.resolve(
                    "generated/source/inkstoneauto/${variant.dirName}")
            val pkg = getPackageName(variant)
            val once = AtomicBoolean()
            variant.outputs.all { output ->
                if (once.compareAndSet(false, true)) {
                    project.tasks.create("generate${variant.name.capitalize()}InkstoneManifest").doLast {
                        println("task genManifest doLast")
                        val xmlFile = File(outputDir, "AndroidManifest.xml")
                        xmlFile.createNewFile()
                    }
                }
            }
        }
    }

}