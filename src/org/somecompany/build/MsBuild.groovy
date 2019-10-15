package org.somecompany.build

import org.somecompany.IStepExecutor
import org.somecompany.ioc.ContextRegistry

class MsBuild implements  Serializable{
    private static IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

    void build(String solutionPath){
        steps
        int returnStatus = steps.bat("echo \"building ${solutionPath}...\"")
        if(returnStatus != 0){
            steps.error("Some error")
        }
    }

   void buildDatabase(String serverName){
       steps
       int returnStatus = steps.bat("sqlcmd \" -S ${serverName} -E \"")
       if(returnStatus != 0){
           steps.error("Some error")
       }
   }

void buildQueryDataBase(String DatabaseName){
        steps
        int returnStatus = steps.bat("CREATE DATABASE ${DatabaseName}")
        if(returnStatus != 0){
            steps.error("Some error")
        }
    }
}
