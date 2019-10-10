node {
    try {
        stage('Example') {
            sh 'exit 1'
        }
    } catch (e) {
        echo 'УПС!'
        error "${e}"
    }
}
