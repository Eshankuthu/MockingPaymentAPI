
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<div class="container">
	<div class='row'>
		<div class='col-md-4'></div>
		<div class='col-md-4'>
			<form method="GET" action="#" class="carddetail">
				<div class='form-row'>
					<div class='col-xs-12 form-group required'>
						<label class='control-label'>Name on Card</label> <input
							class='form-control' size='4' type='text' id="cardname">
					</div>
				</div>
				<div class='form-row'>
					<div class='col-xs-12 form-group card required'>
						<label class='control-label'>Card Number</label> <input
							autocomplete='off' class='form-control card-number' size='20'
							type='text' id="cardnumber">
					</div>
				</div>
				<div class='form-row'>
					<div class='col-xs-4 form-group cvc required'>
						<label class='control-label'>CVV</label> <input autocomplete='off'
							class='form-control card-cvc' placeholder='ex. 311' size='4'
							type='text' id="cvv">

					</div>
					<div class='col-xs-4 form-group expiration required'>
						<label class='control-label'>Expiration Month</label> <input
							class='form-control card-expiry-month' placeholder='MM' size='2'
							type='text' id="month">
					</div>
					<div class='col-xs-4 form-group expiration required'>
						<label class='control-label'>Year</label> <input
							class='form-control card-expiry-year' placeholder='YYYY' size='4'
							type='text' id="year">
					</div>
				</div>

				<div class='form-row'>
					<div class='col-md-12 form-group'>
						<button class='form-control btn btn-primary submit-button'
							type='submit' id="getCard">Add</button>
					</div>
				</div>
				<div class='form-row'>
					<div class='col-md-12 error form-group hide'>
						<div class='alert-danger alert' id="errorprint"></div>
					</div>
				</div>
			</form>
		</div>
		<div class='col-md-4'></div>
	</div>
</div>
<script>
$(document).ready(function(){
   /*  $("#getCard").click(function(){
        alert("this is test");
    }); 
     */
   $("#getCard").click(function(){
    	 const cardname=$("#cardname").val();
    	 const cardnumber=$("#cardnumber").val();
    	 const cvv=$("#cvv").val();
    	 const month=$("#month").val();
    	 const year=$("#year").val();
    	 $.ajax({
             "url": "/sagarmathamarketplace/api/getcard",
             "type": "GET",
             "data":{"cardname":cardname,
            	    "cardnumber":cardnumber,
            	    "cvv":cvv,
    	 			"month":month,
    	 			"year":year
            	   },
            success:function(data){
            	
            	var result="";
            	result += "<h1>" +data.a+"</h1>";
            	$("#errorprint").html(result);
            
            },
            error: function(){
                alert('failure');
              }
    	 
    }); 
 
});
     
});
</script>



