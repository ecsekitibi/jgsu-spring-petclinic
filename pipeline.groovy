
w-definition plugin="workflow-job@2.42">
  <actions/>
  <description></description>
  <keepDependencies>false</keepDependencies>
  <properties/>
  <definition class="org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition" plugin="workflow-cps@2640.v00e79c8113de">
    <script>// Powered by Infostretch 

timestamps {

node () {

	stage (&apos;spring-petclinic - Checkout&apos;) {
 	 checkout([$class: &apos;GitSCM&apos;, branches: [[name: &apos;*/main&apos;]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: &apos;&apos;, url: &apos;https://github.com/ecsekitibi/jgsu-spring-petclinic.git&apos;]]]) 
	}
	stage (&apos;spring-petclinic - Build&apos;) {
 			// Shell build step
sh &quot;&quot;&quot; 
./mvnw package 
 &quot;&quot;&quot;
		archiveArtifacts allowEmptyArchive: false, artifacts: &apos;target/*.jar&apos;, caseSensitive: true, defaultExcludes: true, fingerprint: false, onlyIfSuccessful: false
		// JUnit Results
		junit &apos;target/surefire-reports/*.xml&apos; 
	}
}
}</script>
    <sandbox>false</sandbox>
  </definition>
  <triggers/>
  <disabled>false</disabled>
</flow-definition>
