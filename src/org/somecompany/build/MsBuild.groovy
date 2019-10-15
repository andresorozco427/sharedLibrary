package org.somecompany.build

import org.somecompany.IStepExecutor
import org.somecompany.ioc.ContextRegistry

class MsBuild implements  Serializable{

    void build(String solutionPath){
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.bat("echo \"building ${solutionPath}...\"")
        if(returnStatus != 0){
            steps.error("Some error")
        }
    }

   void buildDatabase(String serverName){
       IStepExecutor steps = ContextRegistry.getContext().getStepExecutor();

       int returnStatus =  steps.bat("sqlcmd \" -S ${serverName} -E \"")
       if(returnStatus != 0){
           steps.error("Some error")
       }
   }

    void buildQueryDatabase(String DatabaseName){
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor();
        int returnStatus = steps.bat("CREATE DATABASE ${DatabaseName}")
        if(returnStatus != 0){
            steps.error("Some error")
        }
    }
}
