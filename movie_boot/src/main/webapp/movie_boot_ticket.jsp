<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
label{display:inline-block;background: #fffffff;border:1px solid #000000;width:20px; height:20px;text-align:center;}
input[type=checkbox]:checked + label{background:red;}
</style>
<script type="text/javascript" src=" https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$.ajax({
    type:"get",
    url:"http://localhost/movie_boot/movieSelectAll.do",
    data : {'key':'430156241533f1d058c603178cc3ca0e'},
    dataType : "json",
    success: function(rs){
      var movieList = rs.movieList;
      console.log(movieList);
      
    },
    error: function(xhr, status, error) {
        alert(error);
    }  
});
</script>
</head>
<body>

<div id='json_a'></div>
<div id='json_b'></div>
<div id='json_c'></div>

<input type="checkbox" id='button_sample' value='aa'  style='display:none;'><label for="button_sample">1</label>
<input type="checkbox" id='button_sample1' value='aa'  style='display:none;'><label for="button_sample1">2</label>
<input type="checkbox" id='button_sample2' value='aa'  style='display:none;'><label for="button_sample2">3</label>
<input type="checkbox" id='button_sample3' value='aa'  style='display:none;'><label for="button_sample3">4</label>
<input type="checkbox" id='button_sample4' value='aa'  style='display:none;'><label for="button_sample4">5</label>
<input type="checkbox" id='button_sample5' value='aa'  style='display:none;'><label for="button_sample5">6</label>
<input type="checkbox" id='button_sample6' value='aa'  style='display:none;'><label for="button_sample6">7</label>
<input type="checkbox" id='button_sample7' value='aa'  style='display:none;'><label for="button_sample7">8</label>
</body>
</html>