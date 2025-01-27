package br.com.fiap.repository;

import br.com.fiap.jogador.DadosAtualizacaoJogador;
import br.com.fiap.jogador.Jogador;
import br.com.fiap.service.JogadorService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogadorRepository {

	private List<Jogador> lista;
	private Long id = 0L;

	public JogadorRepository() {
		lista = new ArrayList<>();
		new JogadorService().mock(this);
	}

	public List<Jogador> findAll() {
		return lista;
	}

	public void save(Jogador jogador) {
		jogador.setId(id++);
		lista.add(jogador);
	}

	public void delete(Jogador jogador) {
		lista.remove(jogador);
	}

	public void deleteById(Long id) {
		lista.remove(findById(id));
	}

	public Jogador findById(Long id) {
		return lista.stream().filter(jogador -> jogador.getId() == id).findFirst().get();
	}

	public void atualizarById(Long id, DadosAtualizacaoJogador dados) {
		findById(id).atualizar(dados);
	}
}
