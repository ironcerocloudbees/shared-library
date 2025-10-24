// This function will be implicitly called at the start of every pipeline's script block.
// It must be named 'call' and accept a Closure as an argument.
def call(body) {
    // --------------------------------------------------------
    // Code to run BEFORE the pipeline script begins execution
    // --------------------------------------------------------
    println "================================================"
    println ">> Global Library Hook: INITIALIZING PIPELINE"
    
    // Example: Set a global environment variable accessible by all steps
    env.BUILD_STARTED_BY = currentBuild.getBuildCauses()[0].getUserName()
    println ">> Build Started By: ${env.BUILD_STARTED_BY}"

    // --------------------------------------------------------
    // Run the actual pipeline script defined in the Jenkinsfile
    // --------------------------------------------------------
    body()

    // --------------------------------------------------------
    // Code to run AFTER the pipeline script finishes execution
    // --------------------------------------------------------
    println ">> Global Library Hook: PIPELINE COMPLETE"
    println "================================================"
}
