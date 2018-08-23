<script>

    /**
     * Add rows to user table in case of valid date.
     * @returns {boolean} true to prevent default action of form.
     */
    function addIfValid() {
        var name=$("#name").val();
        var login=$("#login").val();
        var password=$("#password").val();
        var email=$("#email").val();
        var country=$("#country-opt").val();
        var result = false;
        if (validate(name, login, password, email, country)) {
            var user = createUser(name, login, password, email, country);
            ajax(user);
            true;
        }
        return result;
    }

    /**
     * Validate input data.
     * @param firstName parameter.
     * @param secondName parameter.
     * @param sex parameter.
     * @param description parameter.
     * @returns {boolean} true in if data is valid; false - if not.
     */
    function validate(name, login, password, email, country) {
        var empties = [];
        if (name === "") {
            empties.push(" name");
        }
        if (login === "") {
            empties.push(" login");
        }
        if (password === "") {
            empties.push(" password");
        }
        if (email === "") {
            empties.push(" email");
        }
        if (country === "...") {
            empties.push(" country");
        }
        var result = false;
        if (empties.length === 0) {
            result = true;
        } else {
            alert("The field(s) cant not be empty: "+ empties);
        }
        return result;
    }

    /**
     * Creates JSON string of a person.
     * @param name parameter.
     * @param login parameter.
     * @param password parameter.
     * @param email parameter.
     * @param country parameter.
     * @returns {{name: *, login: *, password: *, email: *, role: *, country: *, city: *}}
     */
    function createUser(name, login, password, email, country) {
        return {
            name: name,
            login: login,
            password: password,
            email: email,
            role: $("#role").val(),
            country: country,
            city: $("#city-opt").val()
        };
    }

    /**
     *  Send ajax request to the a server.
     * @param user parameter.
     */
    function ajax(user) {
        $.ajax({
            type: "POST",
            url: "${context}/items/createThrowJson",
            dataType: "json",
            data: JSON.stringify(user)
        }).done(function (responseJson) {
            if(responseJson!=null){
                $("#usersTable").find("tr:gt(0)").remove();
                var table = $("#usersTable");
                $.each(responseJson, function(key,value) {
                    var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
                    rowNew.children().eq(0)
                        .append('<div><b>Id:</b>' + value['id'])
                        .append('</div><div><b>Created: </b>' + (value['crateDate']) + '</div>');

                    rowNew.children().eq(1)
                        .append('<div><b>Login:</b>' + value['login'])
                        .append('</div><div><b>Password: </b>' + (value['password']) + '</div>')
                        .append('</div><div><b>Role: </b>' + (value['role']) + '</div>');

                    rowNew.children().eq(2)
                        .append('<div><b>Name:</b>' + value['name'])
                        .append('</div><div><b>Email: </b>' + (value['email']) + '</div>')
                        .append('</div><div><b>Country: </b>' + (value['country']) + '</div>')
                        .append('</div><div><b>City: </b>' + (value['city']) + '</div>');
                    rowNew.children().eq(3)
                        .append('<div class=\"col-sm-6\">')
                        .append('<form')
                        .append('action=\"http://localhost:8080/items/remove\" method=\"post\">')
                        .append('<button class=\"btn btn-danger\" value=\"' + (value['id']) + '\"')
                        .append('name=\"id\" type=\"submit\">remove')
                        .append('</button>')
                        .append('</form>')
                        .append('</div>');
                    rowNew.appendTo(table);
                });
            }
        });
    }


    /**
     * The method refresh list of cities according to the country.
     */
    function updateCitiesByCountry() {
        var country = document.getElementById("country-opt").value;
        $.ajax('./cities?country=' + country, {
            method: 'get',
            complete: function (data) {
                var cities = JSON.parse(data.responseText);
                for(var i = 0; i < cities.length; ++i) {
                    document.getElementById("city-opt").options[i] = new Option(cities[i].name, cities[i].name);
                }
            }
        })
    }

    $(document).ready(function(){

        $("#alertSuccess").hide();
        $("#errname").hide();
        $("#errlogin").hide();
        $("#errpass").hide();
        $("#erremail").hide();
        $("#errcountry").hide();

        $("#Rbtn").click(function() {

            addIfValid();
            $("#alertSuccess").show();
            $("#formid").submit();
            return true;


        });


        $("#name").change(function(){
            var username=$("#name").val();
            var letters = /^[A-Za-z]+$/;
            if(!(username.match(letters))){
                $("#errname").show();
                return false;
            }else{
                $("#errname").hide();
                return true;
            }
        });

        $("#login").change(function(){
            var userlogin=$("#login").val();
            var letters = /^[A-Za-z]+$/;
            if(!(userlogin.match(letters))){
                $("#errlogin").show();
                return false;
            }else{
                $("#errlogin").hide();
                return true;
            }
        });

        $("#cpassword").change(function(){
            var password=$("#password").val();
            var cpassword=$("#cpassword").val();
            if(!(password==cpassword)){
                $("#errpass").show();
                return false;

            }else{
                $("#errpass").hide();

                return true;
            }
        });

        $("#email").change(function(){
            var email=$("#email").val();
            var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            if(!(email.match(mailformat))){
                $("#erremail").show();
                return false;
            }else{
                $("#erremail").hide();
                return true;
            }
        });

        $("#country-opt").change(function(){
            var country=$("#country-opt").val();
            var letters = "...";
            if((country == letters)){
                $("#errcountry").show();
                return false;
            }else{
                $("#errcountry").hide();
                return true;
            }
        });

    });

</script>