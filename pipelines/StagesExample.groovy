node('master') {
    stage('Precondition') {
        deleteDir()
    }
    stage('Deploy') {
        	parallel (
                "FRONT" : {
                    sh(label: 'Clone repo',
                        script: """
                            echo "Clone repo from branch ${FRONT_BRANCH}"
                            echo "Build"
                        """)
                }, "BACK" : {
                    sh(label: 'Clone repo',
                        script: """
                            echo "Clone repo from branch ${BACK_BRANCH}"
                            echo "Build"
                        """)
                })

    }
}