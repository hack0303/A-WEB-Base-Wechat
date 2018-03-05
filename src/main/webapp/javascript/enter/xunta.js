$(document).ready(function(){
	$('body #three #nav_left .nav_button:nth-child(1)').click(
			function(){
				window.location.href="ForwardServlet?action=register&type=xunta&step=warning";
			});
	$('body #three #nav_right .nav_button:nth-child(1)').click(
			function(){
				window.location.href="ForwardServlet?action=userlogin&type=xunta";
			});
});