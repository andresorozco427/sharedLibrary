package org.somecompany.build

import groovy.json.JsonSlurper
import org.somecompany.IStepExecutor
import org.somecompany.ioc.ContextRegistry

import java.lang.module.Configuration

class MsBuild implements  Serializable{

    void build(String solutionPath){
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.bat("echo \"building ${solutionPath}...\"")
        if(returnStatus != 0){
            steps.error("Some error")
        }
    }

   void buildEntryFileDatabase(String serverName){
       IStepExecutor steps = ContextRegistry.getContext().getStepExecutor();
       validarExistenciaDelArchivo("C:\\\\Users\\\\andres.orozco\\\\Desktop\\\\returnvalue.sql ", steps)
       steps.bat("sqlcmd -S ${serverName} -E -i C:\\Users\\andres.orozco\\Desktop\\returnvalue.sql -o C:\\Users\\andres.orozco" +
               "\\Desktop\\return.sql")
   }

        def validarExistenciaDelArchivo(String file, IStepExecutor steps) {
            File archivo = new File(file)
            if(archivo.exists()){
                archivo.delete()
                steps.error("Archivo ya existente")
            }
        }
}
