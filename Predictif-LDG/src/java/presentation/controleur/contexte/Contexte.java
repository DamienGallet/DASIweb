/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controleur.contexte;

import presentation.controleur.actions.Action;

/**
 * Classe mere permettant de definir un contexte, soit une partie du site,
 * avec des actions specifiques associees
 * Ainsi, deux parties du site (site.com/employe et site.com/client) pourront,
 * avec un meme todo, effectuer deux actions differentes
 * @author Damien
 */
public abstract class Contexte {
    public abstract Action getAction(String todo);
    public abstract String getVue(String todo);
}
