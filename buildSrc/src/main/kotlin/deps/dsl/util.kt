package deps.dsl

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Adds dependencies to the 'api' configuration.
 *
 * @param dependencyNotations notations for the dependencies to be added.
 * @return The dependencies.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.api(vararg dependencyNotations: Any): List<Dependency?> =
    dependencyNotations.map { dependencyNotation ->
        add("api", dependencyNotation)
    }

/**
 * Adds dependencies to the 'compileOnly' configuration.
 *
 * @param dependencyNotations notations for the dependencies to be added.
 * @return The dependencies.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.compileOnly(vararg dependencyNotations: Any): List<Dependency?> =
    dependencyNotations.map { dependencyNotation ->
        add("compileOnly", dependencyNotation)
    }

/**
 * Adds dependencies to the 'implementation' configuration.
 *
 * @param dependencyNotations notations for the dependencies to be added.
 * @return The dependencies.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.implementation(vararg dependencyNotations: Any): List<Dependency?> =
    dependencyNotations.map { dependencyNotation ->
        add("implementation", dependencyNotation)
    }

/**
 * Adds dependencies to the 'kapt' configuration.
 *
 * @param dependencyNotations notations for the dependencies to be added.
 * @return The dependencies.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.kapt(vararg dependencyNotations: Any): List<Dependency?> =
    dependencyNotations.map { dependencyNotation ->
        add("kapt", dependencyNotation)
    }

/**
 * Adds dependencies to the 'testImplementation' configuration.
 *
 * @param dependencyNotations notations for the dependencies to be added.
 * @return The dependencies.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.testImplementation(vararg dependencyNotations: Any): List<Dependency?> =
    dependencyNotations.map { dependencyNotation ->
        add("testImplementation", dependencyNotation)
    }
