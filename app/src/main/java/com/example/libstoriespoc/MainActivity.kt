package com.example.libstoriespoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libstoriespoc.view.customviews.Action
import com.example.libstoriespoc.view.customviews.CustomStoriesActivity
import com.example.libstoriespoc.view.customviews.HomeStoriesList
import com.example.libstoriespoc.view.customviews.Media
import com.example.libstoriespoc.view.customviews.Thumbnail

class MainActivity : AppCompatActivity() {

    private var customStoriesActivity: CustomStoriesActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customStoriesActivity = findViewById(R.id.customStoriesActivity)
        customStoriesActivity?.setupStories()
    }

    fun storiesList() : MutableList<HomeStoriesList>{
        return mutableListOf(
            HomeStoriesList(
                key = "stories-1-lno-2021-1",
                title = "Nome limpo",
                description = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                viewed = false,
                time = 3000,
                highlight = true,
                thumbnail = Thumbnail(
                    title = "Ilustra de um homem com o braço erguido celebrando.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png"
                ),
                media = Media(
                    title = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/large_85dc5ea466.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/default_85dc5ea466.png"
                ),
                texts = arrayListOf(),
                action = Action(
                    text = "Negocie",
                    action = "/area-cliente/solucoes/negociar",
                    aS = "/area-cliente/solucoes/negociar"
                )
            ),
            HomeStoriesList(
                key = "stories-1-lno-2021-1",
                title = "Nome limpo",
                description = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                viewed = false,
                time = 3000,
                highlight = true,
                thumbnail = Thumbnail(
                    title = "Ilustra de um homem com o braço erguido celebrando.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png"
                ),
                media = Media(
                    title = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/large_85dc5ea466.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/default_85dc5ea466.png"
                ),
                texts = arrayListOf(),
                action = Action(
                    text = "Negocie",
                    action = "/area-cliente/solucoes/negociar",
                    aS = "/area-cliente/solucoes/negociar"
                )
            ),
            HomeStoriesList(
                key = "stories-1-lno-2021-1",
                title = "Nome limpo",
                description = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                viewed = false,
                time = 3000,
                highlight = true,
                thumbnail = Thumbnail(
                    title = "Ilustra de um homem com o braço erguido celebrando.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png"
                ),
                media = Media(
                    title = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/large_85dc5ea466.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/default_85dc5ea466.png"
                ),
                texts = arrayListOf(),
                action = Action(
                    text = "Negocie",
                    action = "/area-cliente/solucoes/negociar",
                    aS = "/area-cliente/solucoes/negociar"
                )
            ),
            HomeStoriesList(
                key = "stories-1-lno-2021-1",
                title = "Nome limpo",
                description = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                viewed = false,
                time = 3000,
                highlight = true,
                thumbnail = Thumbnail(
                    title = "Ilustra de um homem com o braço erguido celebrando.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png"
                ),
                media = Media(
                    title = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/large_85dc5ea466.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/default_85dc5ea466.png"
                ),
                texts = arrayListOf(),
                action = Action(
                    text = "Negocie",
                    action = "/area-cliente/solucoes/negociar",
                    aS = "/area-cliente/solucoes/negociar"
                )
            ),
            HomeStoriesList(
                key = "stories-1-lno-2021-1",
                title = "Nome limpo",
                description = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                viewed = false,
                time = 3000,
                highlight = true,
                thumbnail = Thumbnail(
                    title = "Ilustra de um homem com o braço erguido celebrando.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/e1c31d6e26/default_e1c31d6e26.png"
                ),
                media = Media(
                    title = "Ilustra de um homem com o braço erguido celebrando. A esquerda, o texto \"deixa suas dívidas para trás, até 90% de desconto\". Acima, o logo do Serasa Limpa Nome.",
                    x1 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/large_85dc5ea466.png",
                    x2 = "https://www.serasa.com.br/assets/ssw-files/2021-01-29/85dc5ea466/default_85dc5ea466.png"
                ),
                texts = arrayListOf(),
                action = Action(
                    text = "Negocie",
                    action = "/area-cliente/solucoes/negociar",
                    aS = "/area-cliente/solucoes/negociar"
                )
            )
        )
    }


}