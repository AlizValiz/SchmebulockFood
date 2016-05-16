<?php

/*
 * aDominguez
 * Se crea un WebService para los datos que se almacenan en la 
 * tabla de ordenes
 */

// array para la respuesta del JSON
$response = array();

// campos requeridos
if (isset($_POST['mesaNo']) && isset($_POST['date']) 
    && isset($_POST['plat1']) && isset($_POST['plat1price'])
    && isset($_POST['plat2']) && isset($_POST['plat2price'])
    && isset($_POST['plat3']) && isset($_POST['plat3price'])
    && isset($_POST['bebida']) && isset($_POST['bebidaprice'])
    ) {
    
    $mesaNo = $_POST['mesaNo'];
    $date = $_POST['date'];
    $plat1 = $_POST['plat1'];
    $plat1price = $_POST['plat1price'];
    $plat1 = $_POST['plat2'];
    $plat1price = $_POST['plat2price'];
    $plat1 = $_POST['plat3'];
    $plat1price = $_POST['plat3price'];
    $plat1 = $_POST['bebida'];
    $plat1price = $_POST['bebidaprice'];

    // Incluir coneccion a bd
    require_once __DIR__ . '/db_connect.php';

    // conectando a bd
    $db = new DB_CONNECT();

    // insertar linea
    $result = mysql_query(" INSERT INTO orders (mesaNo, isActivo, created, plat1, plat1price, 
        plat2, plat2price, plat3, plat3price, bebida, bebidaprice) 
    VALUES ('$mesaNo', 'Y','$date','$plat1','$plat1price','$plat2','$plat2price','$plat3','$plat3price','$bebida','$bebidaprice' ) ");

    // Revisar si la linea se inserto correctamente
    if ($result) {
        // inserccion correcta
        $response["success"] = 1;
        $response["message"] = "Product successfully created.";

        // respuesta en echo de JSON
        echo json_encode($response);
    } else {
        // Fallo al insertar la linea
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
        
        // respuesta en echo de JSON
        echo json_encode($response);
    }
} else {
    // Falta un campo
    $response["success"] = 0;
    $response["message"] = "revisar los campos necesarios";

    // respuesta en echo de JSON
    echo json_encode($response);
}
?>