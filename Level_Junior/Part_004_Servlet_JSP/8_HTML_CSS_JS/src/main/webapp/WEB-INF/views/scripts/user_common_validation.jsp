<script>

    /**
     * Validate existing input data.
     * @param name parameter.
     * @param login parameter.
     * @param password parameter.
     * @param email parameter.
     * @param country parameter.
     * @returns {boolean} true if data are present; false - if not.
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
            alert("The field(s) cant not be empty: " + empties);
        }
        return result;
    }

    /**
     * Validate new user login throw send a request to the server via Ajax.
     * @param login parameter.
     * @returns {boolean} true if login is valid; false - if not.
     */
    function validateLogin(login) {
        $.ajax('./checkLogin?loginParam=' + login, {
            method: 'get',
            complete: function (data) {
                if (data.responseText === "free") {
                    return true;
                } else {
                    alert("User with login " + login + " already used");
                    return false;
                }
            }
        })
    }

    /**
     * Validate new user email throw send a request to the server via Ajax.
     * @param email parameter.
     * @returns {boolean} true if email is valid; false - if not.
     */
    function validateEmail(email) {
        $.ajax('./checkEmail?emailParam=' + email, {
            method: 'get',
            complete: function (data) {
                if (data.responseText === "free") {
                    return true;
                } else {
                    alert("User with login " + email + " already used");
                    return false;
                }
            }
        })
    }

    /**
     * The method refresh list of the cities according to the country.
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

</script>