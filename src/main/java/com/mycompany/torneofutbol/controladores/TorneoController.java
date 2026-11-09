
package com.mycompany.torneofutbol.controladores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class TorneoController {

    @FXML private TabPane pestanas;
    @FXML private Button btnGuardar;
    @FXML private Button btnEditar;
    @FXML private Button btnEliminar;
    @FXML private Label lblMensaje;

    @FXML private TextField txtAdministradorUsuario;
    @FXML private Label lblAdministradorUsuarioError;
    @FXML private TextField txtAdministradorNombre;
    @FXML private Label lblAdministradorNombreError;
    @FXML private TextField txtAdministradorApellidos;
    @FXML private Label lblAdministradorApellidosError;
    @FXML private TextField txtAdministradorCorreo;
    @FXML private Label lblAdministradorCorreoError;
    @FXML private ListView<String> listaAdministrador;

    @FXML private TextField txtEquipoNombre;
    @FXML private Label lblEquipoNombreError;
    @FXML private TextField txtEquipoCiudad;
    @FXML private Label lblEquipoCiudadError;
    @FXML private TextField txtEquipoEntrenador;
    @FXML private Label lblEquipoEntrenadorError;
    @FXML private ListView<String> listaEquipo;

    @FXML private TextField txtJugadorNombre;
    @FXML private Label lblJugadorNombreError;
    @FXML private TextField txtJugadorApellidos;
    @FXML private Label lblJugadorApellidosError;
    @FXML private TextField txtJugadorNumero;
    @FXML private Label lblJugadorNumeroError;
    @FXML private TextField txtJugadorPosicion;
    @FXML private Label lblJugadorPosicionError;
    @FXML private ListView<String> listaJugador;

    @FXML private TextField txtPartidoJornada;
    @FXML private Label lblPartidoJornadaError;
    @FXML private TextField txtPartidoFecha;
    @FXML private Label lblPartidoFechaError;
    @FXML private TextField txtPartidoLocal;
    @FXML private Label lblPartidoLocalError;
    @FXML private TextField txtPartidoVisitante;
    @FXML private Label lblPartidoVisitanteError;
    @FXML private ListView<String> listaPartido;

    @FXML private TextField txtResultadoPartido;
    @FXML private Label lblResultadoPartidoError;
    @FXML private TextField txtResultadoGolesLocal;
    @FXML private Label lblResultadoGolesLocalError;
    @FXML private TextField txtResultadoGolesVisitante;
    @FXML private Label lblResultadoGolesVisitanteError;
    @FXML private ListView<String> listaResultado;

    @FXML private TextField txtPosicionEquipo;
    @FXML private Label lblPosicionEquipoError;
    @FXML private TextField txtPosicionPuntos;
    @FXML private Label lblPosicionPuntosError;
    @FXML private TextField txtPosicionJugados;
    @FXML private Label lblPosicionJugadosError;
    @FXML private TextField txtPosicionDiferencia;
    @FXML private Label lblPosicionDiferenciaError;
    @FXML private ListView<String> listaPosicion;

    private final Map<String, TextField> campos = new LinkedHashMap<>();
    private final Map<String, Label> errores = new LinkedHashMap<>();
    private final Map<String, ListView<String>> listas = new LinkedHashMap<>();
    private final Map<String, Integer> consecutivos = new HashMap<>();

    private boolean limpiando = false;

    @FXML
    private void initialize() {

        registrarCampo("Administrador:usuario", txtAdministradorUsuario, lblAdministradorUsuarioError);
        registrarCampo("Administrador:nombre", txtAdministradorNombre, lblAdministradorNombreError);
        registrarCampo("Administrador:apellidos", txtAdministradorApellidos, lblAdministradorApellidosError);
        registrarCampo("Administrador:correo", txtAdministradorCorreo, lblAdministradorCorreoError);

        registrarCampo("Equipo:nombre", txtEquipoNombre, lblEquipoNombreError);
        registrarCampo("Equipo:ciudad", txtEquipoCiudad, lblEquipoCiudadError);
        registrarCampo("Equipo:entrenador", txtEquipoEntrenador, lblEquipoEntrenadorError);

        registrarCampo("Jugador:nombre", txtJugadorNombre, lblJugadorNombreError);
        registrarCampo("Jugador:apellidos", txtJugadorApellidos, lblJugadorApellidosError);
        registrarCampo("Jugador:numero", txtJugadorNumero, lblJugadorNumeroError);
        registrarCampo("Jugador:posicion", txtJugadorPosicion, lblJugadorPosicionError);

        registrarCampo("Partido:jornada", txtPartidoJornada, lblPartidoJornadaError);
        registrarCampo("Partido:fecha", txtPartidoFecha, lblPartidoFechaError);
        registrarCampo("Partido:local", txtPartidoLocal, lblPartidoLocalError);
        registrarCampo("Partido:visitante", txtPartidoVisitante, lblPartidoVisitanteError);

        registrarCampo("Resultado:partido", txtResultadoPartido, lblResultadoPartidoError);
        registrarCampo("Resultado:golesLocal", txtResultadoGolesLocal, lblResultadoGolesLocalError);
        registrarCampo("Resultado:golesVisitante", txtResultadoGolesVisitante, lblResultadoGolesVisitanteError);

        registrarCampo("Posicion:equipo", txtPosicionEquipo, lblPosicionEquipoError);
        registrarCampo("Posicion:puntos", txtPosicionPuntos, lblPosicionPuntosError);
        registrarCampo("Posicion:jugados", txtPosicionJugados, lblPosicionJugadosError);
        registrarCampo("Posicion:diferencia", txtPosicionDiferencia, lblPosicionDiferenciaError);

        listas.put("Administrador", listaAdministrador);
        listas.put("Equipo", listaEquipo);
        listas.put("Jugador", listaJugador);
        listas.put("Partido", listaPartido);
        listas.put("Resultado", listaResultado);
        listas.put("Posicion", listaPosicion);

        for (String entidad : listas.keySet()) {
            consecutivos.put(entidad, 1);

            listas.get(entidad).getSelectionModel()
                    .selectedItemProperty().addListener((obs, anterior, actual) -> {
                if (entidadActual().equals(entidad)) {
                    btnEditar.setDisable(actual == null);
                    btnEliminar.setDisable(actual == null);
                }
            });
        }

        pestanas.getSelectionModel().selectedItemProperty()
                .addListener((obs, anterior, actual) -> {
            if (actual != null) {
                limpiarCamposActuales();
                listas.get(entidadActual()).getSelectionModel().clearSelection();
                restablecerBotones();
                lblMensaje.setText("Gestión de " + entidadActual() + ".");
            }
        });

        restablecerBotones();
    }

    private void registrarCampo(String clave, TextField campo, Label etiquetaError) {

        campos.put(clave, campo);
        errores.put(clave, etiquetaError);

        campo.textProperty().addListener((obs, anterior, actual) -> {

            if (!limpiando && entidadActual().equals(entidadDe(clave))) {
                validarCampo(clave, true);
                actualizarEstadoGuardar();
            }
        });
    }

    private String entidadActual() {
        String nombre = pestanas.getSelectionModel().getSelectedItem().getText();
        return nombre.equals("Posiciones") ? "Posicion" : nombre;
    }

    private String entidadDe(String clave) {
        return clave.substring(0, clave.indexOf(":"));
    }

    private List<String> clavesActuales() {

        String entidad = entidadActual();
        List<String> resultado = new ArrayList<>();

        for (String clave : campos.keySet()) {
            if (entidadDe(clave).equals(entidad)) {
                resultado.add(clave);
            }
        }

        return resultado;
    }

    private boolean esEntero(String clave) {

        return Arrays.asList(
                "Jugador:numero",
                "Partido:jornada",
                "Resultado:golesLocal",
                "Resultado:golesVisitante",
                "Posicion:puntos",
                "Posicion:jugados",
                "Posicion:diferencia"
        ).contains(clave);
    }

    private boolean esTextoConNombre(String clave) {

        return Arrays.asList(
                "Administrador:nombre",
                "Administrador:apellidos",
                "Equipo:ciudad",
                "Equipo:entrenador",
                "Jugador:nombre",
                "Jugador:apellidos",
                "Jugador:posicion"
        ).contains(clave);
    }

    private String mensajeError(String clave, String valor) {

        if (valor.isEmpty()) {
            return "Este campo es obligatorio.";
        }

        if (clave.equals("Administrador:usuario")
                && !valor.matches("[A-Za-z0-9._-]{3,20}")) {
            return "Usa de 3 a 20 caracteres válidos.";
        }

        if (clave.equals("Administrador:correo")
                && !valor.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return "Ingresa un correo válido.";
        }

        if (clave.equals("Partido:fecha")) {
            try {
                DateTimeFormatter formato =
                        DateTimeFormatter.ofPattern("dd/MM/uuuu")
                                .withResolverStyle(ResolverStyle.STRICT);

                LocalDate.parse(valor, formato);

            } catch (Exception ex) {
                return "Usa una fecha válida: dd/mm/aaaa.";
            }
        }

        if (esEntero(clave)) {

            String patron = clave.equals("Posicion:diferencia")
                    ? "-?\\d+" : "\\d+";

            if (!valor.matches(patron)) {
                return "Ingresa un número entero válido.";
            }

            try {
                int numero = Integer.parseInt(valor);

                if (!clave.equals("Posicion:diferencia") && numero < 0) {
                    return "El número no puede ser negativo.";
                }

                if (clave.equals("Jugador:numero")
                        && (numero < 1 || numero > 99)) {
                    return "El número de camiseta debe estar entre 1 y 99.";
                }

            } catch (NumberFormatException ex) {
                return "El número está fuera del rango permitido.";
            }
        }

        if (esTextoConNombre(clave)
                && !valor.matches("[\\p{L}][\\p{L} .'-]*")) {
            return "Utiliza únicamente letras y espacios.";
        }

        if ((clave.equals("Equipo:nombre")
                || clave.endsWith(":local")
                || clave.endsWith(":visitante")
                || clave.endsWith(":partido")
                || clave.equals("Posicion:equipo"))
                && !valor.matches("[\\p{L}0-9][\\p{L}0-9 .,'-]*")) {
            return "Ingresa un nombre válido.";
        }

        return "";
    }

    private boolean validarCampo(String clave, boolean mostrarMensaje) {

        String valor = campos.get(clave).getText().trim();
        String mensaje = mensajeError(clave, valor);

        if (mostrarMensaje) {
            errores.get(clave).setText(mensaje);
        }

        return mensaje.isEmpty();
    }

    private boolean formularioValido(boolean mostrarMensajes) {

        boolean valido = true;

        for (String clave : clavesActuales()) {
            if (!validarCampo(clave, mostrarMensajes)) {
                valido = false;
            }
        }

        return valido;
    }

    private void actualizarEstadoGuardar() {
        btnGuardar.setDisable(!formularioValido(false));
    }

    @FXML
    private void nuevo() {

        limpiarCamposActuales();
        listas.get(entidadActual()).getSelectionModel().clearSelection();
        restablecerBotones();

        lblMensaje.setText("Nuevo registro: captura los datos.");
    }

    @FXML
    private void validar() {

        if (formularioValido(true)) {

            mostrarAlerta(
                    "Validación correcta",
                    "Formulario válido",
                    "Todos los datos cumplen con las validaciones."
            );

            lblMensaje.setText("Validación completada correctamente.");

        } else {

            btnGuardar.setDisable(true);
            lblMensaje.setText("Revisa los campos que contienen errores.");
        }
    }

    @FXML
    private void guardar() {

        if (!formularioValido(true)) {
            btnGuardar.setDisable(true);
            lblMensaje.setText("Revisa los campos antes de guardar.");
            return;
        }

        String entidad = entidadActual();

        int id = consecutivos.get(entidad);
        consecutivos.put(entidad, id + 1);

        List<String> valores = new ArrayList<>();

        for (String clave : clavesActuales()) {
            valores.add(campos.get(clave).getText().trim());
        }

        String registro = id + " | " + String.join(" | ", valores);

        listas.get(entidad).getItems().add(registro);

        lblMensaje.setText("Registro agregado a la lista temporal.");

        limpiarCamposActuales();
        listas.get(entidad).getSelectionModel().clearSelection();
        restablecerBotones();
    }

    @FXML
    private void editar() {

        if (listas.get(entidadActual()).getSelectionModel().getSelectedItem() != null) {
            mostrarAlerta(
                    "Editar",
                    "Acción demostrativa",
                    "Esta acción es únicamente visual."
            );
        }
    }

    @FXML
    private void eliminar() {

        if (listas.get(entidadActual()).getSelectionModel().getSelectedItem() != null) {
            mostrarAlerta(
                    "Eliminar",
                    "Acción demostrativa",
                    "Esta acción es únicamente visual."
            );
        }
    }

    @FXML
    private void limpiar() {

        limpiarCamposActuales();
        listas.get(entidadActual()).getSelectionModel().clearSelection();
        restablecerBotones();

        lblMensaje.setText("Formulario limpio.");
    }

    private void limpiarCamposActuales() {

        limpiando = true;

        for (String clave : clavesActuales()) {
            campos.get(clave).clear();
            errores.get(clave).setText("");
        }

        limpiando = false;
    }

    private void restablecerBotones() {

        btnGuardar.setDisable(true);
        btnEditar.setDisable(true);
        btnEliminar.setDisable(true);
    }

    private void mostrarAlerta(String titulo, String encabezado, String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
}
