package examenGimnasiosJPA;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import examenGimnasiosJPA.entities.Asistente;
import examenGimnasiosJPA.entities.Gimnasio;
import examenGimnasiosJPA.entities.Localidad;

import javax.swing.JCheckBox;

public class Principal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfFiltro;
	private JTextField jtfId;
	private JTextField jtfDniNiePasaporte;
	private JTextField jtfNombre;
	private JTextField jtfApellidos;
	private JTextField jtfFechaNacimiento;
	private JTextField jtfCuotaMensual;
	JComboBox<Asistente> jcbAsistentesFiltrados;
	JComboBox<Gimnasio> jcbGimnasio;
	JComboBox<Localidad> jcbLocalidad; 
	JCheckBox chkActivo;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	
	/**
	 * Create the panel.
	 */
	public Principal() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestin = new JLabel("Gestión de asistentes a gimnasios");
		GridBagConstraints gbc_lblGestin = new GridBagConstraints();
		gbc_lblGestin.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestin.gridwidth = 3;
		gbc_lblGestin.gridx = 0;
		gbc_lblGestin.gridy = 0;
		add(lblGestin, gbc_lblGestin);
		
		JLabel lblGimnasios = new JLabel("Gimnasio:");
		GridBagConstraints gbc_lblGimnasios = new GridBagConstraints();
		gbc_lblGimnasios.insets = new Insets(0, 0, 5, 5);
		gbc_lblGimnasios.anchor = GridBagConstraints.EAST;
		gbc_lblGimnasios.gridx = 0;
		gbc_lblGimnasios.gridy = 1;
		add(lblGimnasios, gbc_lblGimnasios);
		
		jcbGimnasio = new JComboBox<Gimnasio>();
		GridBagConstraints gbc_jcbGimnasio = new GridBagConstraints();
		gbc_jcbGimnasio.insets = new Insets(0, 0, 5, 0);
		gbc_jcbGimnasio.gridwidth = 2;
		gbc_jcbGimnasio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbGimnasio.gridx = 1;
		gbc_jcbGimnasio.gridy = 1;
		add(jcbGimnasio, gbc_jcbGimnasio);
		
		JLabel lblFiltroApellidosAsistente = new JLabel("Filtro apellidos asistente:");
		GridBagConstraints gbc_lblFiltroApellidosAsistente = new GridBagConstraints();
		gbc_lblFiltroApellidosAsistente.anchor = GridBagConstraints.EAST;
		gbc_lblFiltroApellidosAsistente.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltroApellidosAsistente.gridx = 0;
		gbc_lblFiltroApellidosAsistente.gridy = 2;
		add(lblFiltroApellidosAsistente, gbc_lblFiltroApellidosAsistente);
		
		jtfFiltro = new JTextField();
		GridBagConstraints gbc_jtfFiltro = new GridBagConstraints();
		gbc_jtfFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFiltro.gridx = 1;
		gbc_jtfFiltro.gridy = 2;
		add(jtfFiltro, gbc_jtfFiltro);
		jtfFiltro.setColumns(10);
		
		JButton btnFlitrarAsistentes = new JButton("Flitrar asistentes");
		GridBagConstraints gbc_btnFlitrarAsistentes = new GridBagConstraints();
		gbc_btnFlitrarAsistentes.insets = new Insets(0, 0, 5, 0);
		gbc_btnFlitrarAsistentes.gridx = 2;
		gbc_btnFlitrarAsistentes.gridy = 2;
		add(btnFlitrarAsistentes, gbc_btnFlitrarAsistentes);
		
		JLabel lblAsistentesFiltrados = new JLabel("Asistentes filtrados:");
		GridBagConstraints gbc_lblAsistentesFiltrados = new GridBagConstraints();
		gbc_lblAsistentesFiltrados.anchor = GridBagConstraints.EAST;
		gbc_lblAsistentesFiltrados.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsistentesFiltrados.gridx = 0;
		gbc_lblAsistentesFiltrados.gridy = 3;
		add(lblAsistentesFiltrados, gbc_lblAsistentesFiltrados);
		
		jcbAsistentesFiltrados = new JComboBox<Asistente>();
		GridBagConstraints gbc_jcbAsistentesFiltrados = new GridBagConstraints();
		gbc_jcbAsistentesFiltrados.insets = new Insets(0, 0, 5, 0);
		gbc_jcbAsistentesFiltrados.gridwidth = 2;
		gbc_jcbAsistentesFiltrados.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbAsistentesFiltrados.gridx = 1;
		gbc_jcbAsistentesFiltrados.gridy = 3;
		add(jcbAsistentesFiltrados, gbc_jcbAsistentesFiltrados);
		
		JLabel lblDatosDelAsistente = new JLabel("Datos del asistente");
		GridBagConstraints gbc_lblDatosDelAsistente = new GridBagConstraints();
		gbc_lblDatosDelAsistente.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatosDelAsistente.gridwidth = 3;
		gbc_lblDatosDelAsistente.gridx = 0;
		gbc_lblDatosDelAsistente.gridy = 5;
		add(lblDatosDelAsistente, gbc_lblDatosDelAsistente);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 6;
		add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 6;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblDniniepasaporte = new JLabel("DNI/NIE/Pasaporte:");
		lblDniniepasaporte.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDniniepasaporte = new GridBagConstraints();
		gbc_lblDniniepasaporte.anchor = GridBagConstraints.EAST;
		gbc_lblDniniepasaporte.insets = new Insets(0, 0, 5, 5);
		gbc_lblDniniepasaporte.gridx = 0;
		gbc_lblDniniepasaporte.gridy = 7;
		add(lblDniniepasaporte, gbc_lblDniniepasaporte);
		
		jtfDniNiePasaporte = new JTextField();
		GridBagConstraints gbc_jtfDniNiePasaporte = new GridBagConstraints();
		gbc_jtfDniNiePasaporte.gridwidth = 2;
		gbc_jtfDniNiePasaporte.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDniNiePasaporte.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDniNiePasaporte.gridx = 1;
		gbc_jtfDniNiePasaporte.gridy = 7;
		add(jtfDniNiePasaporte, gbc_jtfDniNiePasaporte);
		jtfDniNiePasaporte.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
		gbc_lblLocalidad.anchor = GridBagConstraints.EAST;
		gbc_lblLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalidad.gridx = 0;
		gbc_lblLocalidad.gridy = 8;
		add(lblLocalidad, gbc_lblLocalidad);
		
		jcbLocalidad = new JComboBox<Localidad>();
		GridBagConstraints gbc_jcbLocalidad = new GridBagConstraints();
		gbc_jcbLocalidad.gridwidth = 2;
		gbc_jcbLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcbLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbLocalidad.gridx = 1;
		gbc_jcbLocalidad.gridy = 8;
		add(jcbLocalidad, gbc_jcbLocalidad);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 9;
		add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 9;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 10;
		add(lblApellidos, gbc_lblApellidos);
		
		jtfApellidos = new JTextField();
		GridBagConstraints gbc_jtfApellidos = new GridBagConstraints();
		gbc_jtfApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellidos.gridwidth = 2;
		gbc_jtfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellidos.gridx = 1;
		gbc_jtfApellidos.gridy = 10;
		add(jtfApellidos, gbc_jtfApellidos);
		jtfApellidos.setColumns(10);
		
		chkActivo = new JCheckBox("");
		chkActivo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_chkActivo = new GridBagConstraints();
		gbc_chkActivo.anchor = GridBagConstraints.EAST;
		gbc_chkActivo.insets = new Insets(0, 0, 5, 5);
		gbc_chkActivo.gridx = 0;
		gbc_chkActivo.gridy = 11;
		add(chkActivo, gbc_chkActivo);
		
		JLabel lblActivo = new JLabel("Activo");
		GridBagConstraints gbc_lblActivo = new GridBagConstraints();
		gbc_lblActivo.anchor = GridBagConstraints.WEST;
		gbc_lblActivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblActivo.gridx = 1;
		gbc_lblActivo.gridy = 11;
		add(lblActivo, gbc_lblActivo);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 0;
		gbc_lblFechaDeNacimiento.gridy = 12;
		add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
		jtfFechaNacimiento = new JTextField();
		GridBagConstraints gbc_jtfFechaNacimiento = new GridBagConstraints();
		gbc_jtfFechaNacimiento.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaNacimiento.gridwidth = 2;
		gbc_jtfFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaNacimiento.gridx = 1;
		gbc_jtfFechaNacimiento.gridy = 12;
		add(jtfFechaNacimiento, gbc_jtfFechaNacimiento);
		jtfFechaNacimiento.setColumns(10);
		
		JLabel lblCuotaMensual = new JLabel("Cuota mensual:");
		GridBagConstraints gbc_lblCuotaMensual = new GridBagConstraints();
		gbc_lblCuotaMensual.anchor = GridBagConstraints.EAST;
		gbc_lblCuotaMensual.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuotaMensual.gridx = 0;
		gbc_lblCuotaMensual.gridy = 13;
		add(lblCuotaMensual, gbc_lblCuotaMensual);
		
		jtfCuotaMensual = new JTextField();
		GridBagConstraints gbc_jtfCuotaMensual = new GridBagConstraints();
		gbc_jtfCuotaMensual.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCuotaMensual.gridwidth = 2;
		gbc_jtfCuotaMensual.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuotaMensual.gridx = 1;
		gbc_jtfCuotaMensual.gridy = 13;
		add(jtfCuotaMensual, gbc_jtfCuotaMensual);
		jtfCuotaMensual.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 15;
		add(btnGuardar, gbc_btnGuardar);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("Gimnasios")
		.createEntityManager();
		Localidad l = em.find(Localidad.class, 1);
		Asistente a = em.find(Asistente.class, 1);
		
		System.out.println(a.getGimnasio().getDescripcion());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
}
