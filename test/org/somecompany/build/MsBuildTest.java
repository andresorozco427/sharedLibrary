package org.somecompany.build;

import org.junit.Before;
import org.junit.Test;
import org.somecompany.IStepExecutor;
import org.somecompany.ioc.ContextRegistry;
import org.somecompany.ioc.IContext;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class MsBuildTest {

    private IContext _context;
    private IStepExecutor _steps;

    @Before
    public void setUP(){
        _context = mock(IContext.class);
        _steps = mock(IStepExecutor.class);

        when(_context.getStepExecutor()).thenReturn(_steps);

        ContextRegistry.registerContext(_context);
    }

    @Test
    public void build_callsShStep(){
        //Arrange
        String solutionPath = "some/path/to.sln";
        String severname = "ANDRES-OROZCO";
        MsBuild build = new MsBuild(solutionPath);
        //Act
        build.build();

        //Assert
        verify(_steps).bat(anyString());
    }

    @Test
    public void build_shStepReturnStatusNOtEqualsZero_callsErrorStep(){
        //Arrange
        String solutionPath = "some/path/to.sln";
        String severname = "ANDRES-OROZCO";
        MsBuild build = new MsBuild(solutionPath);

        when(_steps.bat(anyString())).thenReturn(-1);

        //Act
        build.build();

        //Assert
        verify(_steps).error(anyString());

    }
}