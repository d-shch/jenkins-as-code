@Library('lib_name') _

node('master') {
    stage('Precondition') {
        deleteDir()
    }
    stage('Execute tests') {
        sh(label: 'Clone repo',
            script: """
                echo "Clone repo from branch ${BRANCH}"
            """)
        sh(label: 'Execute autotests',
            script: """
                echo "execute autotests for browser ${BROWSER}"
            """)
    }
    stage('Allure report') {
        sh(label: "Create Allure report for example",
            script: """
                mkdir allure-results
                cd allure-results && echo '{"name":"Test","status":"passed","stage":"finished"}' > test.json
            """)
        lib.allureReportExample('allure-results')
    }
}
