package org.somecompany.build

import org.somecompany.IStepExecutor
import org.somecompany.ioc.ContextRegistry

class MsBuild implements  Serializable{
    private String _solutionPath

    MsBuild(String _solutionPath) {
        this._solutionPath = _solutionPath
    }

    void build(){
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.bat("echo \"building ${this._solutionPath}...\"")
        if(returnStatus != 0){
            steps.error("Some error")
        }
    }
}
