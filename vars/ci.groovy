
import org.ff.ci.TestRunner
import jenkins.model.Jenkins

String causeClass = currentBuild.rawBuild.getCauses()[0].getClass().getName()
echo("Cause: ${causeClass}")

def runBuild(script) {
    script.get_jenkins_instance = {
        return Jenkins.instance
    }

    new TestRunner(script).run()
}