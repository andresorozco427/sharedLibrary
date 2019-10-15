package org.somecompany.ioc

class ContextRegistry implements  Serializable{
    private static IContext _context;

    static void registerContext(IContext context){
        _context = context
    }

    static void registerDEfaultContext(Object steps){
        _context = new DefaultContext(steps)
    }

    static  IContext getContext(){
        return _context
    }
}
