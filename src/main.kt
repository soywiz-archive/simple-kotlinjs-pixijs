import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import kotlin.browser.document

fun main(args: Array<String>) {
	val stage = Container(0x66FF99)
	val renderer = autoDetectRenderer(400, 300, RendererExtra(0x1099bb))
	document.body!!.appendChild(renderer.view)

	loader.add("bunny.png").load {
		// create a new Sprite using the texture
		val bunny = Sprite.fromImage("bunny.png")

		// center the sprites anchor point
		bunny.anchor.x = 0.5
		bunny.anchor.y = 0.5

		// move the sprite t the center of the screen
		bunny.position.x = 200.0
		bunny.position.y = 150.0

		bunny.interactive = true
		bunny.onClick {
			bunny.scale.x += 0.3
			bunny.scale.y += 0.3
		}

		stage.addChild(bunny)
		stage.addChild(Text("Hello World!", style = TextStyle(
			fill = "#ffffff"
		)))

		stage.addChild(Graphics().apply {
			beginFill(0xFF3300)
			lineStyle(4, 0xffd900, 1)
			moveTo(50,50);
			lineTo(250, 50);
			lineTo(100, 100);
			lineTo(50, 50);
			endFill();
		})

		requestAnimationLooop { dt ->
			// just for fun, lets rotate mr rabbit a little
			bunny.rotation += 0.1

			// render the stage
			renderer.render(stage)
		}

	}
}
