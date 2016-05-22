<?php
$con=mysqli_connect("mysql13.000webhost.com","a2957838_anduser","mypassword123","a2957838_android");
if (mysqli_connect_errno($con))
{
   echo '{"query_result":"ERROR"}';
}

   $mesaNo = $_GET['mesaNo'];
    $date = $_GET['date'];
    $plat1 = $_GET['plat1'];
    $plat1price = $_GET['plat1price'];
    $plat1 = $_GET['plat2'];
    $plat1price = $_GET['plat2price'];
    $plat1 = $_GET['plat3'];
    $plat1price = $_GET['plat3price'];
    $plat1 = $_GET['bebida'];
    $plat1price = $_GET['bebidaprice'];

$result = mysqli_query($con,
	" INSERT INTO orders (mesaNo, isActivo, created, plat1, plat1price, 
        plat2, plat2price, plat3, plat3price, bebida, bebidaprice) 
    VALUES ('$mesaNo', 'Y','$date','$plat1','$plat1price','$plat2','$plat2price','$plat3','$plat3price','$bebida','$bebidaprice' ) "
          );

if($result == true) {
	echo '{"query_result":"SUCCESS"}';
}
else{
	echo '{"query_result":"FAILURE"}';
}
mysqli_close($con);
?>