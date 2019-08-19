package br.com.sistemas.controleusuarioapi.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sistemas.controleusuarioapi.dao.UsuarioDAO;
import br.com.sistemas.controleusuarioapi.enums.ESexo;
import br.com.sistemas.controleusuarioapi.exception.ModelException;
import br.com.sistemas.controleusuarioapi.model.Usuario;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {
	
	private UsuarioService usuarioService;
	
	@Mock
	private UsuarioDAO usuarioDao;
	
	@Before
	public void setup() {
		this.usuarioService = new UsuarioService();
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testConsultarPorIdParametroNulo() throws Exception {

		exception.expect(ModelException.class);
		exception.expectMessage("O parametro id é requerido!");
		Long id = null;
		usuarioService.consultarPorId(id);
	}
	
	@Test
	public void testCadastroParametroNomeNulo() throws Exception {

		exception.expect(ModelException.class);
		exception.expectMessage("O parametro nome do usuario é requerido!");
		Usuario usuarioCadastro = new Usuario();
		usuarioCadastro.setCpf("123");
		usuarioCadastro.setSexo(ESexo.M);
		usuarioService.cadastrar(usuarioCadastro);
	}
	
	@Test
	public void testCadastroParametroCpfNulo() throws Exception {

		exception.expect(ModelException.class);
		exception.expectMessage("O parametro CPF do usuario é requerido!");
		Usuario usuarioCadastro = new Usuario();
		usuarioCadastro.setNome("Lucas");
		usuarioCadastro.setSexo(ESexo.M);
		usuarioService.cadastrar(usuarioCadastro);
	}
	
	@Test
	public void testCadastroParametroSexoNulo() throws Exception {

		exception.expect(ModelException.class);
		exception.expectMessage("O parametro sexo do usuario é requerido!");
		Usuario usuarioCadastro = new Usuario();
		usuarioCadastro.setNome("Lucas");
		usuarioCadastro.setCpf("123");
		usuarioService.cadastrar(usuarioCadastro);
	}
	
	public void testAlteracaoParametroUsuarioNulo() throws Exception {
		
		exception.expect(ModelException.class);
		exception.expectMessage("O parametro usuario é requerido!");
		Long idUsuario = 1000l;
		Mockito.when(usuarioDao.findById(idUsuario)).thenReturn(null);
		Usuario usuarioAlteracao = usuarioDao.findById(idUsuario).get();
		usuarioService.alterar(usuarioAlteracao);
	}
}
