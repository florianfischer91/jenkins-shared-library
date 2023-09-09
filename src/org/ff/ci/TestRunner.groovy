package org.ff.ci

import jenkins.model.Jenkins
import hudson.plugins.git.GitSCM
import hudson.plugins.git.UserRemoteConfig
import hudson.plugins.git.BranchSpec

class TestRunner {

    private static final String winTmpBase = "C:/J/t/"
    private static final String restTmpBase = "/tmp/"
    private static final String numCores = "4"
    private static final String testModule = "\"conans/test\""
    private script;
    // private TestLevelConfig testLevelConfig

    TestRunner(script){
        // testLevelConfig = new TestLevelConfig(script)
        this.script = script
    }


    void run(){
        // cancelPreviousCommits()
        // testLevelConfig.init() // This will read the tags from the PR if this is a PR
        script.echo("Branch: ${script.env.BRANCH_NAME}")
        String causeClass = this.script.currentBuild.rawBuild.getCauses()[0].getClass().getName()
        script.echo("Cause: ${causeClass}")
        script.stage("Dynamically added") {
            // script.sh(script: "docker --version")
            // script.sh(script: "python3 --version")
            script.sh(script: script.libraryResource('org/ff/ci/scripts/runner.sh'))
        }
        // if(script.env.JOB_NAME == "ConanNightly" || script.env.BRANCH_NAME =~ /(^release.*)|(^master)/) {
        //     runReleaseTests()
        // }
        // else{
        //     runRegularBuildTests()
        // }
    }


}
