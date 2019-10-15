package org.somecompany.build

import org.somecompany.IStepExecutor
import org.somecompany.ioc.ContextRegistry

class MsBuild implements  Serializable{
    private String _solutionPath
    private String _server

    MsBuild(String _solutionPath, String _server) {
        this._solutionPath = _solutionPath
        this._server = _server
    }

    void build(){
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.bat("echo \"building ${this._solutionPath}...\"")
        if(returnStatus != 0){
            steps.error("Some error")
        }
    }

   void buildDatabase(){
       IStepExecutor steps = ContextRegistry.getContext().getStepExecutor();

       int returnStatus = steps.bat("sqlcmd \" -S ${this._server} -E -i C:/Users/andres.orozco/Desktop/returnvalue -o out.log \"")
       if(returnStatus != 0){
           steps.error("Some error")
       }
   }
}
