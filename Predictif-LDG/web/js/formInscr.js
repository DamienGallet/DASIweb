/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function openValid()
{
    alert("Inscription valide !");
}

function checkValid(form) {
    if(form.elements["nom"].value == "") {
        alert("Mal rempli !");
        return false;
    }
}