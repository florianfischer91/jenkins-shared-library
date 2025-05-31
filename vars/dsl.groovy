def folders = ["project-alpha", "project-beta"]

folders.each { folderName ->
    folder(folderName) {
        displayName("Folder: ${folderName}")
        description("This is the ${folderName} folder")

        configure { folderNode ->
            def props = folderNode / 'properties'
            props << 'com.cloudbees.hudson.plugins.folder.properties.AuthorizationMatrixProperty' {
                permission('com.cloudbees.hudson.plugins.folder.AbstractFolder.Read:authenticated')
                permission('USER:hudson.model.Item.Create:user1')
                permission('com.cloudbees.hudson.plugins.folder.AbstractFolder.Build:dev-team')
                permission('com.cloudbees.hudson.plugins.folder.AbstractFolder.Workspace:dev-team')
            }
        }
    }
}

// Multibranch Pipeline Job
multibranchPipelineJob('project-alpha/sample-multibranch-job') {
    description('Multibranch pipeline under project-alpha')

    branchSources {
        git {
            id('git-source')
            remote('https://github.com/your-org/your-repo.git')
            credentialsId('project-alpha-credentials')
        }
    }

    orphanedItemStrategy {
        discardOldItems {
            numToKeep(10)
        }
    }

}
