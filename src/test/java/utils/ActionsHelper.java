package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ActionsHelper {

    public void removeFixedElements() {
        // Проверка наличия jQuery
        executeJavaScript("if (typeof jQuery === 'undefined') {" +
                "   var script = document.createElement('script');" +
                "   script.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js';" +
                "   document.head.appendChild(script);" +
                "   script.onload = function() {" +
                "       jQuery('#fixedban').remove();" +
                "       jQuery('footer').remove();" +
                "   };" +
                "} else {" +
                "   jQuery('#fixedban').remove();" +
                "   jQuery('footer').remove();" +
                "}");
    }
}