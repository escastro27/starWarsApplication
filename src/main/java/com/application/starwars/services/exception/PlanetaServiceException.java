package com.application.starwars.services.exception;

public class PlanetaServiceException extends Exception {
	 /**
     * importante caso a exceção seja serializada
     */
    private static final long serialVersionUID = 1149241039409861914L;

    // constrói um objeto NumeroNegativoException com a mensagem passada por parâmetro
    public PlanetaServiceException(String msg){
        super(msg);
    }

    // contrói um objeto NumeroNegativoException com mensagem e a causa dessa exceção, utilizado para encadear exceptions
    public PlanetaServiceException(String msg, Throwable cause){
        super(msg, cause);
    }
	
	
}
