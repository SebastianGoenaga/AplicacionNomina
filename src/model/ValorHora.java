package model;

/**
 * ValorHora
 */
public enum ValorHora {
    VALOR_HORA_NOCTURNA(1.75f),
    VALOR_HORA_DIURNA(1.25f),
    VALOR_HORA_DOMINICAL_DIURNA(2),
    VALOR_HORA_DOMINICAL_NOCTURNA(2.5f);

    float porcentaje;
    
    private ValorHora(float porcentaje) {
        this.porcentaje = porcentaje;
    }

}