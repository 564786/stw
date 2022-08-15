/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

/**
 *
 * @author rafar
 */
public class Raspberry {
    
    private Long id;
    private String serialNumber;
    private Boolean estado;
    private float[] regsTemperatura;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public float[] getRegsTemperatura() {
        return regsTemperatura;
    }

    public void setRegsTemperatura(float[] regsTemperatura) {
        this.regsTemperatura = regsTemperatura;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    
}
