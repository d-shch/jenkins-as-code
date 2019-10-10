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
                mkdir allure-report
                echo '{"name":"Test","status":"passed","stage":"finished"}' > allure_report/test.json
            """)
        lib_name.allureReportExample('allure_report')
    }
}
