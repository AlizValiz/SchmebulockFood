<?php
$con=mysqli_connect("localhost","admin","admin","orders");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}

   $mesaNo = $_GET['mesaNo'];
    $date = $_GET['date'];
    $plat1 = $_GET['plat1'];
    $plat1price = $_GET['plat1price'];
    $plat2 = $_GET['plat2'];
    $plat2price = $_GET['plat2price'];
    $plat3 = $_GET['plat3'];
    $plat3price = $_GET['plat3price'];
    $bebida = $_GET['bebida'];
    $bebidaprice = $_GET['bebidaprice'];

    $sql = " INSERT INTO orders (mesaNo, isActivo, creado, plat1, plat1price, plat2, plat2price, plat3, plat3price, bebida, bebidaprice) 
    VALUES ('$mesaNo'
    , 'Y'
    ,'$date'
    ,'$plat1'
    ,'$plat1price'
    ,'$plat2'
    ,'$plat2price'
    ,'$plat3'
    ,'$plat3price'
    ,'$bebida'
    ,'$bebidaprice' ) " ;

$result = mysqli_query($con, $sql);

if($result == true) {
	echo '{"query_result":"SUCCESS"}';
}
else{
	echo '{"query_result":"FAILURE"}';
//  echo print $sql;
}
mysqli_close($con);
?>