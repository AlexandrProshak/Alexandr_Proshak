<script>

    /**
     * The method contains listeners of the document
     * and validates correct input date.
     */
    $(document).ready(function(){
        $("#err-name").hide();
        $("#err-login").hide();
        $("#err-pass").hide();
        $("#err-email").hide();
        $("#err-country").hide();
        $("#name").change(function(){
            var name = $("#name").val();
            var letters = /^[A-Za-z]+$/;
            if(!(name.match(letters))){
                $("#err-name").show();
                return false;
            }else{
                $("#err-name").hide();
                return true;
            }
        });
        $("#login").change(function(){
            var login = $("#login").val();
            var oldLogin = $("#old-login").val();
            var letters = /^[A-Za-z]+$/;
            if(!(login.match(letters))){
                $("#err-login").show();
                return false;
            }else{
                $("#err-login").hide();
                if (oldLogin === login) {
                    return true;
                } else {
                    return validateLogin(login);
                }
            }
        });
        $("#cpassword").change(function(){
            var password = $("#password").val();
            var cpassword = $("#cpassword").val();
            if(!(password === cpassword)){
                $("#err-pass").show();
                return false;

            }else{
                $("#err-pass").hide();

                return true;
            }
        });
        $("#email").change(function(){
            var email=$("#email").val();
            var oldEmail = $("#old-email").val();
            var mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            if(!(email.match(mailFormat))){
                $("#err-email").show();
                return false;
            }else{
                $("#err-email").hide();
                if (oldEmail === email) {
                    return true;
                } else {
                    return validateEmail(email);
                }
            }
        });
        $("#country-opt").change(function(){
            var country=$("#country-opt").val();
            var letters = "...";
            if((country === letters)){
                $("#err-country").show();
                return false;
            }else{
                $("#err-country").hide();
                return true;
            }
        });
    });

    /**
     * Add rows to user table in case of valid date.
     * @returns {boolean} true to prevent default action of form.
     */
    function validateUpdateForm() {
        var name = $("#name").val();
        var login = $("#login").val();
        var password = $("#password").val();
        var email = $("#email").val();
        var country = $("#country-opt").val();
        var result = false;
        if (validate(name, login, password, email, country)) {
            result = true;
        }
        return result;
    }

</script>