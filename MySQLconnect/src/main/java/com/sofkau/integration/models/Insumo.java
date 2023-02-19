package com.sofkau.integration.models;

    public class Insumo {
        private int idInsumo;
        private String nombreInsumo;
        private String descripcion;
        private int cantidad;

        public Insumo(int idInsumo, String nombreInsumo, String descripcion, int cantidad) {
            this.idInsumo = idInsumo;
            this.nombreInsumo = nombreInsumo;
            this.descripcion = descripcion;
            this.cantidad = cantidad;
        }

        public Insumo() {
        }

        public int getIdInsumo() {
            return idInsumo;
        }

        public void setIdInsumo(int idInsumo) {
            this.idInsumo = idInsumo;
        }

        public String getNombreInsumo() {
            return nombreInsumo;
        }

        public void setNombreInsumo(String nombreInsumo) {
            this.nombreInsumo = nombreInsumo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
