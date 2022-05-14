/* 테마 컬러 변경 사이드 바 모션 */
function styleSwitcherToggle(){
    const styleSwitcher = document.querySelector(".js-style-switcher"),
    styleSwitcherToggle = document.querySelector(".js-style-switcher-toggler");

    styleSwitcherToggle.addEventListener("click", function(){
        styleSwitcher.classList.toggle("open");
        this.querySelector("i").classList.toggle("fa-times");
        this.querySelector("i").classList.toggle("fa-cog");
    });

}

styleSwitcherToggle();

/* 색 변경  */
function themeColors(){
    const colorStyle = document.querySelector(".js-color-style"),
    themeColorsContainer = document.querySelector(".js-theme-colors");

    themeColorsContainer.addEventListener("click", ({target}) => {
        if(target.classList.contains("js-theme-color-item")){
            localStorage.setItem("color", target.getAttribute("data-js-theme-color"));
            setColor();
        }
    });

function setColor(){
    let path = colorStyle.getAttribute("href").split("/");
    path = path.slice(0, path.length-1);
    colorStyle.setAttribute("href", path.join("/") + "/" + localStorage.getItem("color") + ".css");

    if(document.querySelector(".js-theme-color-item.active")){
        document.querySelector(".js-theme-color-item.active").classList.remove("active");
    }
    document.querySelector("[data-js-theme-color=" + localStorage.getItem("color") + "]").classList.
    add("active");
    }

    if(localStorage.getItem("color") !== null){
        setColor();
    }else{
        const defaultColor = colorStyle.getAttribute("href").split("/").pop().split(".").shift();
        document.querySelector("[data-js-theme-color=" + defaultColor + "]").classList.add("active");
        console.log(defaultColor);
    }
}
themeColors();

/* 다크 모드, 라이트 모드 */
function themeLightDark(){
    const darModeCheckBox = document.querySelector(".js-dark-mode");

    darModeCheckBox.addEventListener("click", function(){
        if(this.checked){
            localStorage.setItem("theme-dark", "true");
        } else {
            localStorage.setItem("theme-dark", "false");
        }
        themeMode();
    });
    
    function themeMode(){
        if(localStorage.getItem("theme-dark") === "false"){
            document.body.classList.remove("t-dark");
        } else {
            document.body.classList.add("t-dark");
        }
    }
}
themeLightDark();