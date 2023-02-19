package com.sofkau.integration.models;

    public class Proveedor {
        private int idProveedor;
        private String nombreProveedor;
        private String direccion;
        private String correo;

        public Proveedor(int idProveedor, String nombreProveedor, String direccion, String correo) {
            this.idProveedor = idProveedor;
            this.nombreProveedor = nombreProveedor;
            this.direccion = direccion;
            this.correo = correo;
        }


        public Proveedor() {
        }

        public int getIdProveedor() {
            return idProveedor;
        }

        public void setIdProveedor(int idProveedor) {
            this.idProveedor = idProveedor;
        }

        public String getNombreProveedor() {
            return nombreProveedor;
        }

        public void setNombreProveedor(String nombreProveedor) {
            this.nombreProveedor = nombreProveedor;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }
    }
