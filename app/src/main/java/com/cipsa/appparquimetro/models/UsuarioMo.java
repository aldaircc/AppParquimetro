package com.cipsa.appparquimetro.models;

import com.android.volley.Response;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ycardenas on 30/03/2017.
 */

public class UsuarioMo {

    @SerializedName("error")
    private  boolean error;

    @SerializedName("ValidarUsuarioResult")
    private List<ValidarUsuarioResult> validarUsuarioResults;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ValidarUsuarioResult> getValidarUsuarioResults() {
        return validarUsuarioResults;
    }

    public void setValidarUsuarioResults(List<ValidarUsuarioResult> validarUsuarioResults) {
        this.validarUsuarioResults = validarUsuarioResults;
    }

    public  static class ValidarUsuarioResult {

        @SerializedName("IdUsuario")
        private  int IdUsuario;
        @SerializedName("Usuario")
        private  String Usuario;
        @SerializedName("ApeNom")
        private  String ApeNom;

        public int getIdUsuario() {
            return IdUsuario;
        }

        public void setIdUsuario(int idUsuario) {
            IdUsuario = idUsuario;
        }

        public String getUsuario() {
            return Usuario;
        }

        public void setUsuario(String usuario) {
            Usuario = usuario;
        }

        public String getApeNom() {
            return ApeNom;
        }

        public void setApeNom(String apeNom) {
            ApeNom = apeNom;
        }
    }
}
