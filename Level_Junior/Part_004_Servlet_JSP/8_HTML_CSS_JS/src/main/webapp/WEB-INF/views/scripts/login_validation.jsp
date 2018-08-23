<script>
    /**
     * Validate input data.
     * @returns {boolean} true in if data is valid; false - if not.
     */
    function validateForm() {
        var login = $('#login').val();
        var password = $('#password').val();
        var empties = [];
        if (login === "") {
            empties.push(" login");
        }
        if (password === "") {
            empties.push(" password");
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
     * Shows password.
     */
    function showPassword() {
        var key_attr = $('#password').attr('type');
        if(key_attr != 'text') {
            $('.checkbox').addClass('show');
            $('#password').attr('type', 'text');
        } else {
            $('.checkbox').removeClass('show');
            $('#password').attr('type', 'password');
        }
    }
</script>