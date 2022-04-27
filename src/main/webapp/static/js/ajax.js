const xhttp = new XMLHttpRequest();

try {
    let addBtns = document.querySelectorAll("#addProductBtn");
    for (let addBtn of addBtns) {
        addBtn.addEventListener("click", function (e) {
            e.preventDefault();
            xhttp.open("POST", "/ajax/add-product");
            xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            let productId = addBtn.getAttribute("data-id");
            let productCount = parseInt(document.getElementById("productInput" + productId).value) + 1;
            const str = "productId=" + productId + "&" + "productCount=" + productCount;

            xhttp.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    refreshStatistics(productCount, productId);
                }
            }
            xhttp.send(str);
        });
    }
} catch (e) {
}


try {
    let removeBtns = document.querySelectorAll("#removeProductBtn");
    for (let removeBtn of removeBtns) {
        removeBtn.addEventListener("click", function (e) {
            e.preventDefault();
            xhttp.open("POST", "/ajax/remove-product");
            xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            let productId = removeBtn.getAttribute("data-id");
            let productCount = parseInt(document.getElementById("productInput" + productId).value) - 1;
            const str = "productId=" + productId + "&" + "productCount=" + productCount;

            xhttp.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    refreshStatistics(productCount, productId);
                }
            }
            xhttp.send(str);
        });
    }
} catch (e) {
}

try {
    let sendEmailBtn = document.querySelector("#sendEmail");
    sendEmailBtn.addEventListener("click", function (e) {
        e.preventDefault();
        sendEmailBtn.disabled = true;
        xhttp.open("POST", "/ajax/send-email");
        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        let email = document.querySelector("#email");
        const parameters = "email=" + email.value;

        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                let code = xhttp.responseText;
                console.log(1);
                console.log(code);
                if (code !== "Email not found") {
                    console.log(code);
                    let registrationDiv = document.querySelector("#registrationDiv");
                    registrationDiv.setAttribute("style", "display:block");
                    let sendEmailDiv = document.querySelector("#sendEmailDiv");
                    sendEmailDiv.setAttribute("style", "display:none");
                    document.querySelector("#uniqueCode").value = code;
                } else {
                    alert("email not found");
                    sendEmailBtn.disabled = false;
                }
            }
        }

        if (checkingDataEntry()) {
            xhttp.send(parameters);
        } else {
            alert("Заполните пожалуйста форму правильно");
            sendEmailBtn.disabled = false;
        }
    });
} catch (e) {
}


try {
    let registrationBtn = document.querySelector("#registrationBtn");
    registrationBtn.addEventListener("click", function (e) {
        e.preventDefault();
        xhttp.open("POST", "/ajax/registration-account");
        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        registrationBtn.disabled = true;

        let firstName = document.querySelector("#firstName");
        let lastName = document.querySelector("#lastName");
        let password = document.querySelector("#password");
        let userName = document.querySelector("#username");
        let email = document.querySelector("#email");
        let uniqueCode = document.querySelector("#uniqueCode");
        let code = document.querySelector("#code");
        switcher(firstName, lastName, userName, password, email, true);

        const parameters = "firstName=" + firstName.value + "&lastName=" + lastName.value
            + "&password=" + password.value + "&userName=" + userName.value + "&email=" + email.value
            + "&uniqueCode=" + uniqueCode.value + "&code=" + code.value;
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                let response = xhttp.responseText;
                if (response === "success") {
                    document.querySelector("#registrationForm").setAttribute("style", "display:none");
                    window.location.replace('http://localhost:8080/main');
                } else {
                    alert("ошибка");
                    window.location.replace('http://localhost:8080/registration');
                    registrationBtn.disabled = false;
                }
            }
        }
        xhttp.send(parameters);
    });
} catch (e) {

}


try {
    let orderBtn = document.querySelector("#orderBtn");
    orderBtn.addEventListener("click", function (e) {
        e.preventDefault();
        xhttp.open("POST", "/ajax/make-order");
        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        orderBtn.disabled = true;
        let telephone = document.querySelector("#telephone");
        let address = document.querySelector("#address");
        let div = document.querySelector("#orderDiv");
        div.setAttribute("style", "display:none");

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                const str = xhttp.responseText;
                if (str === "success") {
                    alert("Заказ успешно обработан");
                } else {
                    alert("ошибка!");
                    div.setAttribute("style", "display:block")
                    orderBtn.disabled = false;
                }
            }
        }
        if (telephone.value.length > 10 && address.value.length > 5) {
            xhttp.send();
        } else {
            alert("Заполните поля правильно");
            div.setAttribute("style", "display:block");
            orderBtn.disabled = false;
        }
    });
} catch (e) {

}

try {
    let changePasswordBtn = document.querySelector("#changePasswordBtn");
    changePasswordBtn.addEventListener("click", function (e) {
        e.preventDefault();
        changePasswordBtn.disabled = true;
        xhttp.open("POST", "/ajax/change-password");

        let password = document.querySelector("#password");
        let newPassword = document.querySelector("#newPassword");
        const parameters = "password=" + password.value + "&newPassword=" + newPassword.value;


        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                let str = xhttp.responseText;
                if (str === "success") {
                    alert("Пароль успешно сменен");
                    location = "http://localhost:8080/account";

                } else {
                    alert("Попробуйте еще раз");
                    changePasswordBtn.disabled = false;
                }
            }
        }
        if (password.value.length > 5 && newPassword.value.length > 5) {
            xhttp.send(parameters);
        } else {
            alert("Заполните форму правильно");
            changePasswordBtn.disabled = false;
        }
    });
} catch (e) {
}

try {
    const userName = document.getElementById("username");
    userName.addEventListener("change", () => {

        xhttp.open("POST", "/ajax/check-duplicate-users");
        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        const str = "userName=" + userName.value;

        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                console.log(xhttp.responseText);
                if (xhttp.responseText == 1) {
                    alert("Такое имя аккаунта уже существует");
                    location = "http://localhost:8080/registration";
                }
            }
        }
        xhttp.send(str);

    });
} catch
    (e) {
}





try {
    let orderBtns = document.getElementsByName("orderBtn");
    for (let orderBtn of orderBtns) {
        orderBtn.addEventListener("click", function (e) {
            e.preventDefault();
            const result = confirm("Вы точно хотите удалить заказ из истории?");

            xhttp.open("POST", "/ajax/account/orders/delete-order");
            xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            let orderId = orderBtn.getAttribute("id");
            const parameters = "orderId=" + orderId;
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4 && xhttp.status === 200) {
                    if (xhttp.responseText === "success") {
                        let orderDiv = document.querySelector("#deleteOrderDiv" + orderId);
                        orderDiv.setAttribute("style", "display:none");
                    }
                }
            }
            if (result == true) {
                xhttp.send(parameters);
            }
        });
    }
} catch (e) {

}

try {
    let responseBtns = document.getElementsByName("responseBtn");
    for (let responseBtn of responseBtns) {
        responseBtn.addEventListener("click", function (e) {
            e.preventDefault();
            let email = responseBtn.getAttribute("data-mail");
            let messageId = responseBtn.getAttribute("data-id")
            xhttp.open("POST", "/ajax/send-response-message");
            xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4 && xhttp.status === 200) {

                }
            }
            let message = prompt("Ответ на сообщение");
            const parameters = "msg=" + message + "&email=" + email + "&id=" + messageId;
            if (message != null) {
                xhttp.send(parameters)
            }
        });
    }
} catch (e) {

}

try {
    let reviewBtn = document.querySelector("#reviewBtn");
    reviewBtn.addEventListener("click", function (e) {
        e.preventDefault();
        let index = document.querySelector("#index");
        let productId = document.querySelector("#productId");
        const url = "/ajax/more-comments?" + "productId=" + productId.value+"&index="+index.value;

        xhttp.open("GET", url);
        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                let str = xhttp.responseText;
                let test = document.querySelector("#test");
                let div = document.createElement("div");
                div.innerHTML = str;
                test.appendChild(div);
                index.value = parseInt(index.value) + 1;
            }
        }

        xhttp.send();
    });
} catch (e) {

}

let addHTMLContent = function (obj) {
    let content = "";
    let userId = document.querySelector("#accountId").value;
    for (let i = 0; i < obj.length; i++) {
        content += "  <div class=\"row\">\n" +
            "            <div class=\"col-3 text-right mt-5\">\n" +
            "                <img src=\"../../../static/img/kolyan.png\" style=\"height: 6vw\">\n" +
            "            </div>\n" +
            "            <div class=\"col-6 text-left border mt-5\">\n" +
            "                <div class=\"row\">\n" +
            "                    <div class=\"col-6\">\n" +
            "                        <label class=\"h5\">" + obj[i].userName + "</label>\n" +
            "                        <label>" + obj[i].email + "</label><br>\n" +
            "                        <p>" + obj[i].text + "</p>\n" +
            "                    </div>\n" +
            "                    <div class=\"col-6 text-right\">\n";
        if (userId == obj[i].accountId) {
            content += "<button><img src=\"../../../static/img/close.png\" style=\"height: 1vw\"></button>\n";
        }
        content +=
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"col-3\">\n" +
            "            </div>\n" +
            "        </div>"
    }
    return content;
}

let checkingDataEntry = function () {
    let firstName = document.querySelector("#firstName");
    let lastName = document.querySelector("#lastName");
    let password = document.querySelector("#password");
    let userName = document.querySelector("#username");
    let email = document.querySelector("#email");

    if (email.value.length < 8 || firstName.value.length < 2
        || lastName.value.length < 2 || password.value.length < 5 || userName.value.length < 5) {
        return false;
    }
    return true;

}


let switcher = function (firstName, lastName, userName, password, email, flag) {
    firstName.disabled = flag;
    lastName.disabled = flag;
    userName.disabled = flag;
    password.disabled = flag;
    email.disabled = flag;

}

let refreshStatistics = function (productCount, productId) {
    let count = productCount;
    let cost = document.getElementById("cost" + productId).getAttribute("data-cost");
    let totalCost = cost * count;
    if (count === 0) {
        let row = document.getElementById("row" + productId).setAttribute("style", "display:none");
    }
    if (count <= 10) {
        document.getElementById("totalCost" + productId).innerHTML = totalCost.toString();
        document.getElementById("productInput" + productId).value = count;
    }
}

