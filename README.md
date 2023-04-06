# kafka-producer
Kafka producer

<h2><strong>Arquitetura do Projeto</strong></h2>

<p><img alt="" src="https://raw.githubusercontent.com/brunocarvalho9810/kafka-producer/master/diagrama.png" style="height:400px; width:1034px" /></p>

<p>&nbsp;</p>

<h2><strong>Repositorios:</strong></h2>

<p><a href="https://github.com/brunocarvalho9810/kafka-producer">Producer</a></p>

<p><a href="https://github.com/brunocarvalho9810/kafka-consumer">Consumer 1</a></p>

<p><a href="https://github.com/brunocarvalho9810/kafka-consumer-2">Consumer 2</a></p>

<p>&nbsp;</p>

<h2><strong>Depend&ecirc;ncias Utilizadas</strong></h2>

<h3><strong>Producer</strong></h3>

<p>&nbsp; &nbsp; &nbsp; &nbsp; Java 11<br />
&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Starter Web<br />
&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Kafka<br />
&nbsp; &nbsp; &nbsp; &nbsp; Dev Tolls<br />
&nbsp; &nbsp; &nbsp; &nbsp; Lombok</p>

<p><strong>Consumer</strong></p>

<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;</strong> Java 11<br />
&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Kafka<br />
&nbsp; &nbsp; &nbsp; &nbsp; Dev Tolls<br />
&nbsp; &nbsp; &nbsp; &nbsp; Lombok</p>

<h2><strong>Como Rodar o Projeto Localmente</strong></h2>

<p>1 - Fa&ccedil;a o download do Git para seu sistema operacional pelo site&nbsp;<a href="https://git-scm.com/downloads">https://git-scm.com/downloads</a>, logo apos fa&ccedil;a a instala&ccedil;&atilde;o.</p>

<p>2 - Fa&ccedil;a o download do Docker&nbsp;no site&nbsp;<a href="https://www.docker.com/products/docker-desktop/">https://www.docker.com/products/docker-desktop/&nbsp;</a>,&nbsp; logo apos fa&ccedil;a a instala&ccedil;&atilde;o.</p>

<p>3 - Abra uma pasta que deseja salvar os projetos, clica&nbsp;com bot&atilde;o direito e vai ate a op&ccedil;&atilde;o <strong>Git Bash Here, </strong>clone os repositorios citados a cima utilizando o comando git clone.</p>

<p>Ex: <span style="color:#7f8c8d">git clone&nbsp;https://github.com/brunocarvalho9810/kafka-consumer-2.git.&nbsp;</span></p>

<p>Fa&ccedil;a isso para os tr&ecirc;s reposit&oacute;rios.</p>

<p>4 - Dentro do mesmo terminal do Git Bash entre na pasta do kafka producer utilizando o comando&nbsp;<span style="color:#7f8c8d">cd kafka-producer</span></p>

<p>5 - Abra o programa Docker Desktop e agora vamos subir&nbsp;os dois containers necessarios para rodar o projeto, o container do kafka e o container do zookeeper. Para fazer isso de forma facil, basta executar o comando&nbsp;<span style="color:#7f8c8d">docker-compose up</span> dentro do mesmo terminal do git bash</p>

<p>Obs: Caso tenha fechado o terminal do Git Bash basta abrir o terminal novamente refazendo o passo 3, porem agora dentro da pasta do kafka producer, onde contem o arquivo&nbsp;docker-compose.yml, esse arquivo que utilizamos para subir os containers.</p>

<p>6 - Apos os containers serem executados, agora podemos executar nossas aplica&ccedil;&otilde;es. Para fazer isso basta utilizar uma IDE de sua preferencia (IntelliJ, Eclipse,etc) e rodar o projeto na op&ccedil;&atilde;o Run.</p>

<p>7 - Logo apos as aplica&ccedil;&otilde;es serem executadas agora podemos testar, abra o navegador de sua preferencia e utilize o endpoit&nbsp;<span style="color:#7f8c8d">http://localhost:8080/send&nbsp;</span>para enviar uma serie de numeros de 1 ao 50 para o topico &quot;topic-1&quot; e utlize o endpoint&nbsp;<span style="color:#7f8c8d">http://localhost:8080/send-person</span> para enviar um objeto do tipo Person para o topico &quot;person-topic&quot;. As mensagens vao aparecer nos logs das aplica&ccedil;&otilde;es consumidores.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>
