package com.panda.demo.guiasTransportista.modelos;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.panda.demo.facturas.modelos.Factura;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

public class GuiaTransportista {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "serie_guia", nullable = false)
    private String serieGuia;

    @Column(name = "numero_guia")
    private Integer numeroGuia;

    @Column(name = "partida", nullable = false)
    private String partida;

    @Column(name = "llegada", nullable = false)
    private String llegada;

    @Column(name = "fecha_emision")
    private Timestamp fechaEmision;
    @PrePersist
    protected void onCreate() {
        // Verificar si la fecha de ingreso ya está establecida
        if (this.fechaEmision == null) {
            // Si la fecha de ingreso no está establecida, establecerla como la fecha y hora
            // actual
            this.fechaEmision = new Timestamp(System.currentTimeMillis());
        }
    }
    @Column(name = "fecha_traslado", nullable = false)
    private Timestamp fechaTraslado;

    @Column(name = "remitente_ruc", nullable = false)
    private String remitenteRuc;

    @Column(name = "remitente_razonsocial", nullable = false)
    private String remitenteRazonSocial;

    @Column(name = "remitente_direccion")
    private String remitenteDireccion;

    @Column(name = "destinatario_ruc", nullable = false)
    private String destinatarioRuc;

    @Column(name = "destinatario_razonsocial", nullable = false)
    private String destinatarioRazonSocial;

    @Column(name = "destinatario_direccion")
    private String destinatarioDireccion;

    @Column(name = "peso_carga", nullable = false)
    private BigDecimal pesoCarga;

    @Column(name = "num_doc_chofer", nullable = false)
    private String numDocChofer;

    @Column(name = "nombre_chofer", nullable = false)
    private String nombreChofer;

    @Column(name = "placa_vehiculo", nullable = false)
    private String placaVehiculo;

    @Column(name = "ruc_pagador_del_flete", nullable = false)
    private String rucPagadorDelFlete;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura;
}
