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
    var success = true;
    success = checkElement(form.elements["nom"]) && success;
    success = checkElement(form.elements["prenom"]) && success;
    success = checkElement(form.elements["civilite"]) && success;
    success = checkElement(form.elements["adresse"]) && success;
    success = checkElement(form.elements["telephone"]) && success;
    success = checkElement(form.elements["mail"]) && success;
    if(success) {
        return true;
    } else {
        alert("Eroor")
        return false;
    }
}

function checkElement(element) {
    if(element.value=="") {
        element.className = "field_error";
        return false;
    } else {
        element.className = "field_ok";
        return true;
    }
}

function addMedium() {
    var nbMediums = getNbMedium();
    var lastListeMedium = document.getElementById("mediums").lastElementChild;
    var newListeMedium = lastListeMedium.cloneNode(true);
    newListeMedium.name = "listeDesMediums"+nbMediums;
    lastListeMedium.parentNode.appendChild(newListeMedium);
}

function removeMedium() {
    if(getNbMedium()>1){
        var lastListeMedium = document.getElementById("mediums").lastElementChild;
        document.getElementById("mediums").removeChild(lastListeMedium);
    }
}

function getNbMedium() {
    var enfants = document.getElementById("mediums").childNodes;
    var nbMediums=0;
    for(i=0; i<enfants.length;i++) {
        if(enfants[i].className=="listeChoix") {
            nbMediums++;
        }
    }
    alert(nbMediums);
    return nbMediums;
}