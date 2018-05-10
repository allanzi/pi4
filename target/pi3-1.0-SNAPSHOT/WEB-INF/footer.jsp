<%-- 
    Document   : footer
    Created on : 04/10/2017, 17:38:53
    Author     : allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer class="page-footer teal">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Astec Games</h5>
                <p class="grey-text text-lighten-4">Somos uma loja de jogos focada em fornecer o melhor custo benefício, maior praticidade e a mais rápida entrega do mercado.</p>


            </div>
            <div class="col l3 s12">
                <h5 class="white-text">Contato</h5>
                <ul>
                    <li><a class="white-text" href="#!">Avenida Engenheiro Eusébio Stevaux, 899</a></li>
                    <li><a class="white-text" href="#!">Santo Amaro - São Paulo/SP</a></li>
                    <li><a class="white-text" href="#!">+55 (011) 5966-8888</a></li>
                    <li><a class="white-text" href="#!">contato@astecgames.com.br</a></li>
                </ul>
            </div>
            
            
            <div class="col l3 s12 right">
                <h5 class="white-text">Suporte</h5>
                <form action="#" method="POST">
                    <select required="required" name="Assunto">
                        <option value="" disabled selected>Assunto</option>
                        <option value="1">Permissões</option>
                        <option value="2">Erros</option>
                        <option value="3">Outros</option>
                    </select>
                    <textarea name="Mensagem" required="required" placeholder="Mensagem" id="textarea1" class="materialize-textarea" data-length="255" maxlength="255"></textarea>
                    <button  type="submit" class="btn btn-default waves-effect waves-light" name="action">Enviar
                        <i class="material-icons right">send</i>
                    </button>
                </form>
            </div>
            
            
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            Made by <a class="brown-text text-lighten-3" href="http://materializecss.com">TARDIS</a>
        </div>
    </div>
</footer>

  <div id="delete" class="modal">
    <div class="modal-content">
      <h4><i class="material-icons">warning</i> Tem certeza ?</h4>
      <p>O item será apagado permanentemente!!</p>
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cancelar</a>
      <a href="#!" class="waves-effect waves-green btn-flat red white-text" id="btn-delete">Excluir</a>
    </div>
  </div>
