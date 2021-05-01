import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCal extends JFrame {


    private JPanel god;                      //Contiene los contenedores de numneros y de simbolos
    private JPanel dataPanel;                //Contenedor donde cuadamos los JtexFIelds
    private JTextField dataSaved;            //Contenedor de los datos introducidos anteriormente
    private JTextField data;                 //Contenedor de los datos
    private JPanel numbers;                  //Contenedor de los botones numericos
    private JPanel others;                   //Contenedor de los botones del 0 la coma y convertirlo a negativo o positivo
    private JPanel symbols;                  //Contenedor de los botones simbolos

    ViewCal() throws HeadlessException {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes

    }


    private void configurarVentana(){
        this.setTitle("Calculadora @version 0.1");
        this.setSize(500, 540);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

    }

    private void inicializarComponentes() {


        // creamos los componentes
        dataPanel = new JPanel();
        dataSaved = new JTextField();
        data = new JTextField();
        numbers = new JPanel();
        others = new JPanel();
        symbols = new JPanel();
        god = new JPanel();

        //Configuramos los componentes
        god.setLayout(new GridLayout(1,2));
        god.add(numbers);
        god.add(symbols);

        //Configuracion de lso datos visuales
        dataPanel.setLayout(new BorderLayout());
        dataPanel.add(dataSaved, BorderLayout.NORTH);
        dataPanel.add(data, BorderLayout.SOUTH);


        //Datos introducidos anteriormente
        dataSaved.setFont(new Font("Dialog", Font.BOLD, 20));
        dataSaved.setPreferredSize(new Dimension(330 ,40));
        dataSaved.setBackground(Color.LIGHT_GRAY);               // seleccionamos el color que queremos darle
        dataSaved.setEditable(false);                            // para que no podamos editar el numero
        dataSaved.setHorizontalAlignment(JTextField.RIGHT);


        //Caja
        data.setFont(new Font("Dialog", Font.BOLD, 34));
        data.setPreferredSize(new Dimension(330 ,40));
        data.setBackground(Color.WHITE);                                // seleccionamos el color que queremos darle
        data.setEditable(false);                                         // para que no podamos editar el numero
        data.setText("0");                                              // el numero inicial que aparece.
        data.setHorizontalAlignment(JTextField.RIGHT);
        data.setBorder(new EmptyBorder(4, 4, 4, 4));


        //Teclado Numerico
        numbers.setLayout(new GridLayout(3,3));
        for (int i = 1; i < 10; i++) {
            JButton btn = new JButton(""+i);
            btn.setFont(new Font("Dialog", Font.BOLD, 30));
            btn.addActionListener(e -> {
                String numero = btn.getText();
                if (data.getText().equalsIgnoreCase("0")){
                    data.setText(numero);
                } else {
                    data.setText(data.getText() + numero);
                }

            });
            numbers.add(btn);
        }

        //Teclado +/- , el 0 , la coma y el =

        others.setLayout(new GridLayout(1,2));

        //Boton +/-
        JButton masMenos = new JButton("+/-");
        masMenos.setFont(new Font("Dialog", Font.BOLD, 30));
        masMenos.addActionListener(e -> {
            float f = Float.parseFloat(data.getText());
            if (f != 0) {
                if (f > 0.0f) {
                    data.setText("-" + data.getText());
                } else {
                    data.setText(data.getText().substring(1));
                }
            }
        });

        //Boton 0
        JButton cero = new JButton("0");
        cero.setFont(new Font("Dialog", Font.BOLD, 30));
        cero.addActionListener(e -> {
            String numero = cero.getText();
            if (data.getText().equalsIgnoreCase("0")){
                data.setText(numero);
            } else {
                data.setText(data.getText() + numero);
            }

        });

        //Boton ","
        JButton coma = new JButton(".");
        coma.setFont(new Font("Dialog", Font.BOLD, 30));
        coma.addActionListener(e -> {
            if(!data.getText().contains(".")){
                data.setText(data.getText()+ ".");
            }
        });


        //Boton "="
        JButton igual = new JButton("=");
        igual.setFont(new Font("Dialog", Font.BOLD, 30));
        igual.addActionListener( new ControllerCal.igualListener());
        JPanel izq = new JPanel ();
        izq.setLayout(new GridLayout(1,3));
        izq.add(masMenos);
        izq.add(cero);
        izq.add(coma);
        others.add(izq);
        others.add(igual);



        //Teclado de los simbolos

        JButton botonBorrar = new JButton("AC");
        botonBorrar.setFont(new Font("Dialog", Font.BOLD, 30));
        botonBorrar.addActionListener( new ControllerCal.ACListener());

        JButton botonRetroceso = new JButton("C");
        botonRetroceso.setFont(new Font("Dialog", Font.BOLD, 30));
        botonRetroceso.addActionListener(e -> {
            if(!data.getText().equalsIgnoreCase("0")){
                if (data.getText().length() > 1 ){
                    data.setText(data.getText().substring(0, data.getText().length()-1));
                } else {
                    data.setText("0");
                }
            }

        });

        //Boton %

        JButton porcentaje = new JButton("%");
        porcentaje.setFont(new Font("Dialog", Font.BOLD, 30));
        porcentaje.addActionListener(new ControllerCal.PercentListener());

        //Boton x²

        JButton potencia2 = new JButton("x²");
        potencia2.setFont(new Font("Dialog", Font.BOLD, 30));
        potencia2.addActionListener(new ControllerCal.PowListener());

        //Boton √

        JButton raizCuadrada = new JButton("√");
        raizCuadrada.setFont(new Font("Dialog", Font.BOLD, 30));
        raizCuadrada.addActionListener(new ControllerCal.SqrtListener());

        symbols.setLayout(new GridLayout(3,1));
        symbols.add(botonRetroceso);
        symbols.add(botonBorrar);
        symbols.add(raizCuadrada);
        symbols.add(potencia2);
        symbols.add(porcentaje);
        crearBotonesOperaciones("+");
        crearBotonesOperaciones("-");
        crearBotonesOperaciones("*");
        crearBotonesOperaciones("/");


        // agregamos los componentes a la ventana
        this.add(dataPanel, BorderLayout.NORTH);
        this.add(god, BorderLayout.CENTER);
        this.add(others, BorderLayout.SOUTH);

    }

    private void crearBotonesOperaciones(String simbolo){
        JButton btn = new JButton(simbolo);
        btn.setFont(new Font("Dialog", Font.BOLD, 30));
        btn.addActionListener(new ControllerCal.OperatorListener());

        symbols.add(btn);
    }

    //GETTERS


    public JTextField getDataSaved() {
        return dataSaved;
    }

    public JTextField getData() {
        return data;
    }
}


