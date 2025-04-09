package jlucas.primeiro_projeto.interfaces.controller.v1.exception;

import jlucas.primeiro_projeto.utils.Constantes;

public class SemRetornoException extends Exception
{
    public SemRetornoException()
    {
        super(Constantes.Erros.SEM_RESULTADOS);
    }
}
